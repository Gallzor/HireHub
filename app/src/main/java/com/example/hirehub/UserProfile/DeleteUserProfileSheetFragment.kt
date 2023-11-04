package com.example.hirehub.UserProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentDeleteUserProfileSheetBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.viewmodels.ProfileViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DeleteUserProfileSheetFragment (var profile: Profile?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDeleteUserProfileSheetBinding
    private lateinit var profileViewModel: ProfileViewModel

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        binding.confirmDeleteUserProfileButton.setOnClickListener {
            confirmDeleteAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDeleteUserProfileSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun confirmDeleteAction() {
        // Haal het profiel op uit de ViewModel en gebruik de juiste functie om deze te verwijderen.
        profileViewModel.deleteProfile(profile!!)

        // Laat bericht zien dat het is gelukt
        showToast("Your profile has been deleted!")

        // Sluit het bottom sheet nadat het profiel is verwijderd
        dismiss()
    }
}