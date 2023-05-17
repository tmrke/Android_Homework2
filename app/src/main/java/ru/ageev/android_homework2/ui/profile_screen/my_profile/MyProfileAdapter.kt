package ru.ageev.android_homework2.ui.profile_screen.my_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewMyProfileCardBinding
import javax.inject.Inject

class MyProfileAdapter @Inject constructor(private val profile: Profile?) :
    RecyclerView.Adapter<MyProfileViewHolder>() {

    var onClick: (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProfileViewHolder {
        val binding =
            ViewMyProfileCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyProfileViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: MyProfileViewHolder, position: Int) {
        if (profile != null) {
            holder.bind(profile)
        }
    }
}