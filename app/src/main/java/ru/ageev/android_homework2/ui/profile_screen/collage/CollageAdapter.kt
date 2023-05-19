package ru.ageev.android_homework2.ui.profile_screen.collage


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding
import javax.inject.Inject

class CollageAdapter @Inject constructor(
) :
    RecyclerView.Adapter<CollageViewHolder>() {
    var onClick: () -> Unit = {}
    lateinit var profile: Profile

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollageViewHolder {
        val binding =
            ViewCollageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CollageViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: CollageViewHolder, position: Int) {
        val image0 = profile.images.getOrNull(0)?.sizes?.getOrNull(2)?.url
        val image1 = profile.images.getOrNull(1)?.sizes?.getOrNull(2)?.url
        val image2 = profile.images.getOrNull(2)?.sizes?.getOrNull(2)?.url
        val image3 = profile.images.getOrNull(3)?.sizes?.getOrNull(2)?.url




        holder.bind(image0, image1, image2, image3)
    }
}