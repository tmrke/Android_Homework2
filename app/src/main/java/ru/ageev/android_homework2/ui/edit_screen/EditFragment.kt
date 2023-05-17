package ru.ageev.android_homework2.ui.edit_screen

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentEditBinding
import ru.ageev.android_homework2.ui.insets.Inset

class EditFragment : Fragment(R.layout.fragment_edit) {
    private val binding by viewBinding(FragmentEditBinding::bind)

    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                lifecycleScope.launch {
                    binding.imageViewUserProfileImage.load(uri)
                }
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)

        Inset.setInsets(binding.root)

        val uri = arguments?.getString("uri")
        val name = arguments?.getString("name")
        val bio = arguments?.getString("bio")

        with(binding) {
            editTextName.setText(name)
            editTextBio.setText(bio)

            if (uri == "null") {
                imageViewUserProfileImage.load(R.drawable.profile)
            } else {
                imageViewUserProfileImage.load(uri)
            }

            imageButtonAddImage.setOnClickListener {
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
        }





        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController = Navigation.findNavController(requireView())
            if (navController.currentDestination?.id == R.id.createPostFragment) {
                navController.navigate(R.id.myProfileFragment)
            }
        }

        binding.toolBar.menu.findItem(R.id.createPostMenu).let { icon ->
            icon.setOnMenuItemClickListener {
                navController.navigate(R.id.myProfileFragment)

                return@setOnMenuItemClickListener true      //сначала осуществляет переход на фрагмент, потом return true
            }
        }


        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.myProfileFragment)
        }
    }
}