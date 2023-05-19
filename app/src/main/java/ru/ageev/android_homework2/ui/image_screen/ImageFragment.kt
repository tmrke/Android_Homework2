package ru.ageev.android_homework2.ui.image_screen

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentImageBinding
import ru.ageev.android_homework2.databinding.ItemImageBinding
import ru.ageev.android_homework2.ui.insets.Inset

@AndroidEntryPoint
class ImageFragment : Fragment(R.layout.fragment_image) {
    private val binding by viewBinding(FragmentImageBinding::bind)
    private val viewModel by viewModels<ImageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        Inset.setInsets(view)

        val imageId = arguments?.getString("imageId")

        if (imageId != null) {
            viewModel.getImage(imageId)
        }

        viewModel.imageLiveData.observe(viewLifecycleOwner) { image ->
            with(binding) {
                imageView.load(image.sizes[0].url)
                textViewDate.text = image.dateCreated
                textViewUserName.text = image.owner.displayName
                imageViewUserProfileImage.load(image.owner.avatarUrl)
            }
        }

        binding.toolbar.menu.findItem(R.id.actionDelete).setOnMenuItemClickListener {
            if (imageId != null) {
                viewModel.deleteImage(imageId)
            }

            return@setOnMenuItemClickListener true
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController.popBackStack()
        }

        binding.toolbar.setNavigationOnClickListener {
            navController.popBackStack()
        }


    }
}