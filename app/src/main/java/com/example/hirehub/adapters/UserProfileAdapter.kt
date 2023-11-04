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
    // Lijst met gebruikersprofielen die aan de adapter wordt doorgegeven
    private var profiles: List<Profile>,
    // Click listener voor gebruikersacties
    private val clickListener: ProfileboardClickListener
) : RecyclerView.Adapter<UserProfileViewHolder>() {

    private lateinit var sessionManager: SessionManager // Instantie van SessionManager voor gebruikerssessiebeheer

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {
        // Inflating van de gebruikersprofielitem layout en aanmaken van een view holder
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserProfileItemCellBinding.inflate(inflater, parent, false)
        return UserProfileViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.bindProfile(profile)
    }

    override fun getItemCount(): Int {
        // Geeft het aantal gebruikersprofielen in de lijst terug
        return profiles.size
    }

    // Functie om de lijst met gebruikersprofielen bij te werken met nieuwe gegevens
    fun updateProfiles(updatedProfiles: List<Profile>) {
        profiles = updatedProfiles
        // Breng de adapter op de hoogte van de gewijzigde gegevens
        notifyDataSetChanged()
    }
}