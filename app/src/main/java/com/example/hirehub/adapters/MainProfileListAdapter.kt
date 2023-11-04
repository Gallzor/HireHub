package com.example.hirehub.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.clicklisteners.MainProfileClickListener
import com.example.hirehub.databinding.MainProfileListItemCellBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.viewholders.MainProfileListViewHolder

class MainProfileListAdapter(
    // Een lijst van profielen die weergegeven moeten worden
    private val profiles: List<Profile>,
    // Een kliklistener om te reageren op klikgebeurtenissen
    private val clickListener: MainProfileClickListener
) : RecyclerView.Adapter<MainProfileListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainProfileListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainProfileListItemCellBinding.inflate(inflater, parent, false)

        // Een nieuwe view holder wordt aangemaakt en geretourneerd
        return MainProfileListViewHolder(binding)
    }

    // Het aantal profielen in de lijst
    override fun getItemCount(): Int = profiles.size

    override fun onBindViewHolder(holder: MainProfileListViewHolder, position: Int) {
        // Het profiel wordt aan de view holder gebonden
        holder.bindProfile(profiles[position])

        // Een klikgebeurtenis wordt toegevoegd aan elk item in de lijst
        holder.itemView.setOnClickListener {
            val profile = profiles[position]
            // Roep de klikgebeurtenis op met het geselecteerde profiel
            clickListener.onProfileItemClick(profile)
        }
    }
}