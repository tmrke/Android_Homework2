package ru.ageev.android_homework2;

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding
import kotlin.jvm.JvmOverloads;

class ViewProfileCard @JvmOverloads constructor(
    context: Context, attrSet: AttributeSet? = null, defAttrsSet: Int = 0
) : ConstraintLayout(context, attrSet, defAttrsSet) {
    private var binding: ViewProfileCardBinding

    init {
        binding = ViewProfileCardBinding.inflate(
            LayoutInflater.from(context), this, true
        )

        context.withStyledAttributes(
            attrSet, R.styleable.ViewProfileCard, defAttrsSet, 0
        ) {
            getString(R.styleable.ViewProfileCard_textViewUserName).let { userName ->
                binding.textViewUserName.text = userName
            }
            getString(R.styleable.ViewProfileCard_textViewUserStatus).let { userStatusText ->
                binding.textViewUserName.text = userStatusText
            }

            getString(R.styleable.ViewProfileCard_textViewImagesCount).let { imagesCountText ->
                binding.textViewUserName.text = imagesCountText
            }
            getString(R.styleable.ViewProfileCard_textViewImages).let { imagesText ->
                binding.textViewUserName.text = imagesText
            }

            getString(R.styleable.ViewProfileCard_textViewSubscribersCount).let { subscribersCountText ->
                binding.textViewUserName.text = subscribersCountText
            }
            getString(R.styleable.ViewProfileCard_textViewSubscribers).let { subscribersText ->
                binding.textViewUserName.text = subscribersText
            }

            getString(R.styleable.ViewProfileCard_textViewPostsCount).let { postsCountText ->
                binding.textViewUserName.text = postsCountText
            }
            getString(R.styleable.ViewProfileCard_textViewPosts).let { postsText ->
                binding.textViewUserName.text = postsText
            }

            getString(R.styleable.ViewProfileCard_buttonSubscribeText).let { buttonSubscribeText ->
                binding.textViewUserName.text = buttonSubscribeText
            }
            getString(R.styleable.ViewProfileCard_buttonSubscribeColor).let { buttonSubscribeColor ->
                binding.textViewUserName.text = buttonSubscribeColor
            }

            getString(R.styleable.ViewProfileCard_buttonSubscribeColor).let { buttonSubscribeColor ->
                binding.textViewUserName.text = buttonSubscribeColor
            }

            getDrawable(R.styleable.ViewProfileCard_imageProfile).let { image ->
                binding.imageViewUserProfileImage.setImageDrawable(image)
            }

            getColor(
                R.styleable.ViewProfileCard_buttonSubscribeColor, Color.parseColor("#49454F")
            ).let { color ->
                binding.buttonSubscribe.setBackgroundColor(color)
            }
        }
    }

    fun setUserNameText(text: String) {
        binding.textViewUserName.text ?: text
    }

    fun changeColorButton() {
        binding.buttonSubscribe.setBackgroundColor(Color.parseColor("#FF0000"))
    }
}
