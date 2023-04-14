package ru.ageev.android_homework2.first_screen.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding
import ru.ageev.android_homework2.first_screen.post.PostData

class ProfileAdapter(private val profiles: List<ProfileData>) :
    RecyclerView.Adapter<ProfileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding =
            ViewProfileCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProfileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return profiles.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(profiles[position])
    }
}