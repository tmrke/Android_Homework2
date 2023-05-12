package ru.ageev.android_homework2.ui.creator_post_screen

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
import ru.ageev.android_homework2.data.model.NewPost
import ru.ageev.android_homework2.databinding.FragmentCreatorPostBinding

class CreatorPostFragment : Fragment(R.layout.fragment_creator_post) {
    private val binding by viewBinding(FragmentCreatorPostBinding::bind)
    private val creatorViewModel by viewModels<CreatorPostViewModel>()

    private var toDeleteUri: String? = null

    //TODO узнать как получить размер изображения
    private var imagesUriList: MutableList<String> = mutableListOf()
    private val adapter = ImagesCreatorPostAdapter(imagesUriList)


    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                lifecycleScope.launch {
                    imagesUriList.add(uri.toString())

                    //TODO какая то рама с удалением, посмотреть
                    adapter.onCancelClick = { imagesUriList.remove(uri.toString()) }
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
                val newPost = NewPost(binding.editText.text.toString())
                //creatorViewModel.addPost(newPost)

                navController.navigate(R.id.profileFragment)
                true
            }

        }
        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
    }


}