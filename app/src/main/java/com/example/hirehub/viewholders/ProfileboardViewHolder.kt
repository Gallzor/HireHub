package com.example.hirehub.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.clicklisteners.ProfileboardClickListener
import com.example.hirehub.databinding.ProfileboardItemCellBinding
import com.example.hirehub.models.Profile

class ProfileboardViewHolder(
    private val context: Context,
    private val binding: ProfileboardItemCellBinding,
    private val clickListener: ProfileboardClickListener
) : RecyclerView.ViewHolder(binding.root) {

    // Functie om een profiel aan het view item te binden
    fun bindProfile(profile: Profile) {
        binding.firstName.text = profile.firstname
        binding.lastName.text = profile.lastname

        // Een click listener instellen voor het bewerken van het profiel bij het klikken op het view item
        binding.profileboardCellContainer.setOnClickListener {
            clickListener.editProfile(profile)
        }

        binding.deleteProfileboardButton.setOnClickListener {
            clickListener.deleteProfile(profile)
        }
    }
}
