package ru.ageev.android_homework2.first_screen.profile

import android.media.midi.MidiDeviceInfo.PortInfo
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding

class ProfileViewHolder(
    private val binding: ViewProfileCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ProfileData) {
        binding.imageViewUserProfileImage.load(item.profileImageUrl)
        binding.textViewUserName.text = item.name
        binding.textViewUserStatus.text = item.status
    }
}