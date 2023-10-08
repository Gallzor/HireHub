package com.example.hirehub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.clicklisteners.ProfileboardClickListener
import com.example.hirehub.databinding.ProfileboardItemCellBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.viewholders.ProfileboardViewHolder

class ProfileboardAdapter(
    private val profiles: List<Profile>,  // Lijst met profielen die aan de adapter wordt doorgegeven
    private val clickListener: ProfileboardClickListener,  // Click listener voor profielsacties
    private var filteredProfiles: List<Profile> = profiles
) : RecyclerView.Adapter<ProfileboardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileboardViewHolder {
        // Inflating van de profielitem layout en aanmaken van een view holder
        val from = LayoutInflater.from(parent.context)
        val binding = ProfileboardItemCellBinding.inflate(from, parent, false)
        return ProfileboardViewHolder(parent.context, binding, clickListener)

    }
    fun filterProfiles(query: String) {
        filteredProfiles = if (query.isEmpty()) {
            profiles
        } else {
            profiles.filter { it.firstname.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = filteredProfiles.size  // Geeft het aantal profielen in de lijst terug

    override fun onBindViewHolder(holder: ProfileboardViewHolder, position: Int) {
        // Deze functie wordt aangeroepen om de gegevens van een bepaalde profiel aan de view holder te binden, op basis van de positie in de lijst.
        holder.bindProfile(filteredProfiles[position])
    }

}
