package ru.ageev.android_homework2.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding =
            ViewProfileCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProfileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {

    }
}