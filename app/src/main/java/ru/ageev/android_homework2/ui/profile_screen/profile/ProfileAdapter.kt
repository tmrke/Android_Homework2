package ru.ageev.android_homework2.ui.profile_screen.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding
import javax.inject.Inject

class ProfileAdapter @Inject constructor(private val profile: Profile?) :
    RecyclerView.Adapter<ProfileViewHolder>() {

    var onClick: (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding =
            ViewProfileCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProfileViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        if (profile != null) {
            holder.bind(profile)
        }
    }
}