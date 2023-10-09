package com.example.hirehub.Profileboard

import android.os.Bundle
import android.text.Editable
import android.util.Log
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
            binding.firstName.setText(profile!!.firstname)
            binding.lastName.setText(profile!!.lastname)
            binding.city.setText(profile!!.city ?: "") // Zorg ervoor dat null wordt behandeld
            binding.age.setText(profile!!.age ?: "")
        } else {
            binding.profileTitle.text = "New Profile"
        }

        // ViewModel aanmaken voor gebruikersacties
        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
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
        val age = binding.age.text.toString()
        val city = binding.city.text.toString()

        Log.d("NewProfileSheetFragment", "First name: $firstname")
        Log.d("NewProfileSheetFragment", "Last name: $lastname")
        Log.d("NewProfileSheetFragment", "City: $city")
        Log.d("NewProfileSheetFragment", "Age: $age")

        if (profile == null) {
            val newProfile = Profile(firstname, lastname, city, null, age, null, null, null, null, true, 0)
            profileViewModel.addProfile(newProfile)
        } else {
            profile!!.firstname = firstname ?: ""
            profile!!.lastname = lastname ?: ""
            profile!!.age = age ?: ""
            profile!!.city = city ?: ""
            profileViewModel.updateProfile(profile!!)
        }

        binding.firstName.setText("")
        binding.lastName.setText("")
        binding.age.setText("")
        binding.city.setText("")
        dismiss()
    }
}