package ru.ageev.nanopost.ui.search_fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.paging.cachedIn
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.ageev.nanopost.R
import ru.ageev.nanopost.databinding.FragmentSearchBinding
import ru.ageev.nanopost.ui.insets.Inset

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel by viewModels<SearchViewModel>()
    private val searchAdapter = SearchAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        Inset.setInsets(binding.root)

        var searchJob: Job? = null

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                searchJob?.cancel()

                searchJob = CoroutineScope(Dispatchers.Main).launch {
                    delay(500)

                    viewModel.searchProfile(binding.editText.text.toString())
                }
            }
        })


        viewModel.searchResultLiveData.cachedIn(viewLifecycleOwner.lifecycleScope)
            .observe(viewLifecycleOwner) { profile ->
                searchAdapter.submitData(viewLifecycleOwner.lifecycle, profile)
            }

        binding.recyclerView.adapter = searchAdapter

        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.feedFragment)
        }

        searchAdapter.onPostClick = { profileId ->
            navController.navigate(
                SearchFragmentDirections.actionSearchFragmentToMyProfileFragment(profileId)
            )
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (navController.currentDestination?.id == R.id.searchFragment) {
                navController.navigate(R.id.feedFragment)
            }
        }
    }
}