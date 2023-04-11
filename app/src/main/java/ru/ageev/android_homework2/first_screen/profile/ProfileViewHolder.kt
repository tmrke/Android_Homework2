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
        binding.imageViewUserProfileImage.load("https://fanibani.ru/wp-content/uploads/2023/01/face-black-women-model-portrait-red-makeup-photography-green-hair-mouth-melons-pink-skin-clothing-head-funny-hats-color-child-g-scaled.jpg")
        binding.textViewUserName.text = item.name
        binding.textViewUserStatus.text = item.status
    }
}