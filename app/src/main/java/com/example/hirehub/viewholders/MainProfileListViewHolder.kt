package com.example.hirehub.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.databinding.MainProfileListItemCellBinding
import com.example.hirehub.models.Profile

class MainProfileListViewHolder(private val binding: MainProfileListItemCellBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindProfile(profile: Profile) {
        binding.firstName.text = profile.firstname
        binding.lastName.text = profile.lastname
        binding.skillOne.text = profile.skillOne
        binding.certificate.text = profile.certificate
    }
}
