package ru.ageev.android_homework2.ui.creator_post_screen

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentCreatorPostBinding
import ru.ageev.android_homework2.service.CreatePostService

class CreatorPostFragment : Fragment(R.layout.fragment_creator_post) {
    private val binding by viewBinding(FragmentCreatorPostBinding::bind)
    private val viewModel by viewModels<CreatorPostViewModel>()


    private var imagesUriList: MutableList<Uri> = mutableListOf()
    private val adapter = ImagesCreatorPostAdapter(imagesUriList)


    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                lifecycleScope.launch {
                    val position = imagesUriList.size
                    imagesUriList.add(uri)

                    adapter.onCancelClick = {
                        imagesUriList.removeAt(position)
                        adapter.notifyItemRemoved(position)
                    }

                    adapter.notifyItemInserted(position)

                    binding.recyclerView.adapter = adapter
                }
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)


        binding.imageButtonAddImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }


        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController = Navigation.findNavController(requireView())
            if (navController.currentDestination?.id == R.id.createPostFragment) {
                navController.navigate(R.id.profileFragment)
            }
        }

        binding.toolBar.menu.findItem(R.id.createPostMenu).let { icon ->
            icon.setOnMenuItemClickListener {

                requireContext().startService(
                    CreatePostService.newIntent(
                        requireContext(),
                        binding.editText.text.toString(),
                        imagesUriList
                    )
                )

                navController.navigate(R.id.profileFragment)

                true
            }

        }
        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
    }


}