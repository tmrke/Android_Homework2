package ru.ageev.android_homework2.ui.images_screen

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.paging.cachedIn
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentImagesBinding
import ru.ageev.android_homework2.ui.insets.Inset

@AndroidEntryPoint
class ImagesFragment : Fragment(R.layout.fragment_images) {
    private val binding by viewBinding(FragmentImagesBinding::bind)
    private val viewModel by viewModels<ImagesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)

        Inset.setInsets(view)

        val profileId = arguments?.getString("profileId")

        viewModel.getAllImages(profileId.toString())


        val imagesAdapter = ImagesAdapter()

        binding.recyclerView.adapter = imagesAdapter

        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.myProfileFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController = Navigation.findNavController(requireView())
            if (navController.currentDestination?.id == R.id.imagesFragment) {
                navController.navigate(R.id.myProfileFragment)
            }
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            //TODO обновить

            binding.swipeRefreshLayout.isRefreshing = false
        }

        viewModel.imagesLiveData.cachedIn(viewLifecycleOwner.lifecycleScope)
            .observe(viewLifecycleOwner) { images ->
                imagesAdapter.submitData(viewLifecycleOwner.lifecycle, images)
            }
    }
}