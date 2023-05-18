package ru.ageev.android_homework2.ui.search_fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.paging.cachedIn
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentSearchBinding
import ru.ageev.android_homework2.ui.insets.Inset

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel by viewModels<SearchViewModel>()
    private val searchAdapter = SearchAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        Inset.setInsets(binding.root)

        binding.buttonSearch.setOnClickListener {
            viewModel.searchProfile(binding.editText.text.toString())
        }

        viewModel.searchResultLiveData.cachedIn(viewLifecycleOwner.lifecycleScope)
            .observe(viewLifecycleOwner) { profile ->
                searchAdapter.submitData(viewLifecycleOwner.lifecycle, profile)
            }

        binding.recyclerView.adapter = searchAdapter
    }
}