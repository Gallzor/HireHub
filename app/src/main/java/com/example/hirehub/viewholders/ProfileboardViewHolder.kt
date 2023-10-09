package com.example.hirehub.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.clicklisteners.UserboardClickListener
import com.example.hirehub.databinding.UserItemCellBinding
import com.example.hirehub.models.User

class ProfileboardViewHolder(
    private val context: Context,
    private val binding: UserItemCellBinding,
    private val clickListener: UserboardClickListener
) : RecyclerView.ViewHolder(binding.root) {

    // Functie om een gebruiker aan het view item te binden
    fun bindUser(user: User) {
        binding.username.text = user.username
        binding.password.text = user.password

        // Een click listener instellen voor het bewerken van de gebruiker bij het klikken op het view item
        binding.userCellContainer.setOnClickListener {
            clickListener.editUser(user)
        }

        binding.deleteUserButton.setOnClickListener {
            clickListener.deleteUser(user)
        }
    }
}
