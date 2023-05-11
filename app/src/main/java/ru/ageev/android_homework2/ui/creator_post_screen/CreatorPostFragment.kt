package ru.ageev.android_homework2.ui.creator_post_screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentCreatorPostBinding

class CreatorPostFragment : Fragment(R.layout.fragment_creator_post) {
    private val binding by viewBinding(FragmentCreatorPostBinding::bind)
    private val authViewModel by viewModels<CreatorPostViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController = Navigation.findNavController(requireView())
            if (navController.currentDestination?.id == R.id.createPostFragment) {
                navController.navigate(R.id.profileFragment)
            }
        }



        binding.toolBar.menu.findItem(R.id.createPostMenu).let { icon ->
            icon.setOnMenuItemClickListener {

                //TODO сохрание данных с поста

                navController.navigate(R.id.profileFragment)

                true
            }

        }
        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
    }


}