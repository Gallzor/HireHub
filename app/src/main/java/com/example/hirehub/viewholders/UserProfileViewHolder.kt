package com.example.hirehub.viewholders

import android.content.Context
import android.text.Editable
import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.R
import com.example.hirehub.clicklisteners.ProfileboardClickListener
import com.example.hirehub.databinding.UserProfileItemCellBinding
import com.example.hirehub.models.Profile

class UserProfileViewHolder(
    private val context: Context,
    private val binding: UserProfileItemCellBinding,
    private val clickListener: ProfileboardClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bindProfile(profile: Profile) {
        binding.firstName.text = profile.firstname
        binding.lastName.text = profile.lastname
        binding.city.text = profile.city
        binding.age.text = profile.age
        binding.email.text = profile.email
        binding.skillOne.text = profile.skillOne
        binding.certificate.text = profile.certificate
        binding.mobileNumber.text = profile.mobileNumber

        // Voeg eventuele click listeners toe voor de knoppen
        binding.userProfileCellContainer.setOnClickListener {
            clickListener.editProfile(profile)
        }
        binding.deleteUserProfileboardButton.setOnClickListener {
            clickListener.deleteProfile(profile)
        }
        binding.visibilityUserProfileboardButton.apply {
            setImageResource(if (profile.isVisible) R.drawable.ic_eye_open else R.drawable.ic_eye_closed)
            setOnClickListener {
                clickListener.toggleVisibility(profile)
            }
        }
    }
}