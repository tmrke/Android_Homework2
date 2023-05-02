package ru.ageev.android_homework2.presentation.profile_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ConcatAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.CollageData
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.data.PostData
import ru.ageev.android_homework2.databinding.FragmentProfileBinding
import ru.ageev.android_homework2.presentation.profile_screen.collage.CollageAdapter
import ru.ageev.android_homework2.presentation.profile_screen.post.PostAdapter
import ru.ageev.android_homework2.presentation.profile_screen.profile.ProfileAdapter
import ru.ageev.android_homework2.presentation.profile_screen.profile.ProfileViewModel
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModels<ProfileViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        val collageAdapter = CollageAdapter(listOf(CollageData()))
        val postAdapter = PostAdapter()

        postAdapter.submitList(listOf(PostData(), PostData(), PostData()))

        collageAdapter.onClick = {
            navController.navigate(R.id.imagesFragment)
        }

//        postAdapter.onClick = {
//            navController.navigate(R.id.postFragment)
//        }
//
        viewModel.getProfile()

        viewModel.profileLiveData.observe(viewLifecycleOwner) { profile ->
            val profileAdapter = ProfileAdapter(profile)
            binding.recyclerView.adapter = ConcatAdapter(profileAdapter, collageAdapter, postAdapter)
        }
    }
}