package com.example.hirehub.Profileboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentDeleteProfileSheetBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.viewmodels.ProfileViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//Afhankelijk van of de gebruiker wordt bewerkt of een nieuw profiel wordt toegevoegd,
// wordt de titel van het bottom sheet en de tekstvelden dienovereenkomstig ingesteld.

class DeleteProfileSheetFragment(var profile: Profile?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDeleteProfileSheetBinding
    private lateinit var profileViewModel: ProfileViewModel

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
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
        // Haal het profiel op uit de ViewModel en gebruik de juiste functie om deze te verwijderen.
        profileViewModel.deleteProfile(profile!!)

        // Laat bericht zien dat het is gelukt
        showToast("The profile has been deleted!")

        // Sluit het bottom sheet nadat het profiel is verwijderd
        dismiss()
    }
}