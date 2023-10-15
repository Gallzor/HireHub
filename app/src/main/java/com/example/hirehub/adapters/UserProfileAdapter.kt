package com.example.hirehub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.clicklisteners.ProfileboardClickListener
import com.example.hirehub.databinding.ProfileboardItemCellBinding
import com.example.hirehub.databinding.UserProfileItemCellBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.utils.SessionManager
import com.example.hirehub.viewholders.ProfileboardViewHolder
import com.example.hirehub.viewholders.UserProfileViewHolder

class UserProfileAdapter(
    private var profiles: List<Profile>,
    private val clickListener: ProfileboardClickListener
) : RecyclerView.Adapter<UserProfileViewHolder>() {

    private lateinit var sessionManager: SessionManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserProfileItemCellBinding.inflate(inflater, parent, false)
        return UserProfileViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.bindProfile(profile)
    }

    override fun getItemCount(): Int {
        return profiles.size
    }

    // Update the list of profiles
    fun updateProfiles(updatedProfiles: List<Profile>) {
        profiles = updatedProfiles
        notifyDataSetChanged()
    }
}