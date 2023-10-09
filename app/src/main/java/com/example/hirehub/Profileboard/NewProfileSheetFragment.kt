package com.example.hirehub.Profileboard

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentNewProfileSheetBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.viewmodels.ProfileViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//Afhankelijk van of de gebruiker wordt bewerkt of een nieuwe gebruiker wordt toegevoegd,
// wordt de titel van het bottom sheet en de tekstvelden dienovereenkomstig ingesteld.

class NewProfileSheetFragment(var profile: Profile?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewProfileSheetBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        // Instellingen voor de weergave op basis van het bewerken van een bestaand profiel of het toevoegen van een nieuw profiel
        if (profile != null) {
            binding.profileTitle.text = "Edit Profile"
            val editable = Editable.Factory.getInstance()
            binding.firstName.text = editable.newEditable(profile!!.firstname)
            binding.lastName.text = editable.newEditable(profile!!.lastname)
        } else {
            binding.profileTitle.text = "New Profile"
        }

        // ViewModel aanmaken voor gebruikersacties
        profileViewModel = ViewModelProvider(activity).get(ProfileViewModel::class.java)
        binding.saveProfileButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewProfileSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Functie voor het opslaan van een nieuw profiel of bijwerken van een bestaande profiel
    private fun saveAction() {
        val firstname = binding.firstName.text.toString()
        val lastname = binding.lastName.text.toString()
        if (profile == null) {
            // Nieuw profiel aanmaken en toevoegen aan de database
            val newProfile = Profile(firstname, lastname)
            profileViewModel.addProfile(newProfile)
        } else {
            // Bestaand profiel bijwerken met de nieuwe gegevens
            profile!!.firstname = firstname
            profile!!.lastname = lastname
            profileViewModel.updateProfile(profile!!)
        }

        // Tekstvelden legen en het bottom sheet sluiten
        binding.firstName.setText("")
        binding.lastName.setText("")
        dismiss()
    }
}
