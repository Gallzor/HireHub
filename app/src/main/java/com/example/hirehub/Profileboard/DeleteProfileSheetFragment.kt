package com.example.hirehub.Profileboard

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentDeleteProfileSheetBinding
import com.example.hirehub.databinding.FragmentDeleteUserSheetBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.models.User
import com.example.hirehub.viewmodels.ProfileViewModel
import com.example.hirehub.viewmodels.UserViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//Afhankelijk van of de profiel wordt bewerkt of een nieuwe profiel wordt toegevoegd,
// wordt de titel van het bottom sheet en de tekstvelden dienovereenkomstig ingesteld.

class DeleteProfileSheetFragment(var profile: Profile) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDeleteProfileSheetBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
        binding.confirmDeleteProfileButton.setOnClickListener {
            confirmDeleteAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDeleteProfileSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun confirmDeleteAction() {
        // Haal de profiel op uit de ViewModel en gebruik de juiste functie om deze te verwijderen.
        profileViewModel.deleteProfile(profile!!)

        // Sluit het bottom sheet nadat de profiel is verwijderd
        dismiss()
    }
}