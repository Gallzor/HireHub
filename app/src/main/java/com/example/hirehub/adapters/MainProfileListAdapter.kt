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
    private val profiles: List<Profile>,
    private val clickListener: MainProfileClickListener
) : RecyclerView.Adapter<MainProfileListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainProfileListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainProfileListItemCellBinding.inflate(inflater, parent, false)
        return MainProfileListViewHolder(binding)
    }

    override fun getItemCount(): Int = profiles.size

    override fun onBindViewHolder(holder: MainProfileListViewHolder, position: Int) {
        holder.bindProfile(profiles[position])
        holder.itemView.setOnClickListener {
            val profile = profiles[position]
            clickListener.onProfileItemClick(profile)
        }
    }
}