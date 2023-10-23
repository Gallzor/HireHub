package com.example.hirehub.UserProfile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentNewUserProfileSheetBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.utils.SessionManager
import com.example.hirehub.viewmodels.ProfileViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewUserProfileSheetFragment(private var profile: Profile?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewUserProfileSheetBinding
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var sessionManager: SessionManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialiseer de sessionManager
        sessionManager = SessionManager(requireContext())

        // Instellingen voor de weergave op basis van het bewerken van een bestaand profiel of het toevoegen van een nieuw profiel
        if (profile != null) {
            binding.userProfileTitle.text = "Edit your Profile"
            binding.firstName.setText(profile!!.firstname)
            binding.lastName.setText(profile!!.lastname)
            binding.city.setText(profile!!.city ?: "") // Zorg ervoor dat null wordt behandeld
            binding.age.setText(profile!!.age ?: "")
            binding.email.setText(profile!!.email ?: "")
            binding.skillOne.setText(profile!!.skillOne ?: "")
            binding.certificate.setText(profile!!.certificate ?: "")
            binding.mobileNumber.setText(profile!!.mobileNumber ?: "")
        } else {
            binding.userProfileTitle.text = "New Profile"
        }

        // ViewModel aanmaken voor gebruikersacties
        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
        binding.saveUserProfileButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewUserProfileSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Functie voor het opslaan van een nieuw profiel of bijwerken van een bestaande profiel
    private fun saveAction() {
        val userId = sessionManager.getUserId()

        val firstname = binding.firstName.text.toString()
        val lastname = binding.lastName.text.toString()
        val age = binding.age.text.toString()
        val city = binding.city.text.toString()
        val email = binding.email.text.toString()
        val skillOne = binding.skillOne.text.toString()
        val certificate = binding.certificate.text.toString()
        val mobileNumber = binding.mobileNumber.text.toString()

        // Voer validatie uit
        if (firstname.isEmpty() || firstname.length > 40) {
            // Toon een foutmelding voor 'firstname'
            binding.firstName.error = "Please fill in a correct name. Limit of 40 characters"
            return
        }

        if (lastname.isEmpty() || lastname.length > 40) {
            // Toon een foutmelding voor 'lastname'
            binding.lastName.error = "Please fill in a correct name. Limit of 40 characters"
            return
        }

        if (age.isEmpty() || age.length > 3) {
            // Toon een foutmelding voor 'age'
            binding.age.error = "Please fill in your age. No more then 3 numbers"
            return
        }

        if (city.length > 40) {
            // Toon een foutmelding voor 'city'
            binding.city.error = "Please fill in your current city of residence. Limit of 40 characters"
            return
        }

        if (email.isEmpty() || !email.contains("@")) {
            // Toon een foutmelding voor 'email'
            binding.email.error = "Please input your email. It should contain a @"
            return
        }

        if (skillOne.length > 40) {
            // Toon een foutmelding voor 'skillOne'
            binding.skillOne.error = "Please fill your best skills in. Limit of 40 characters"
            return
        }

        if (certificate.length > 30) {
            // Toon een foutmelding voor 'certificate'
            binding.certificate.error = "Please fill your latest earned degree. Limit of 30 characters."
            return
        }

        if (mobileNumber.length > 12) {
            // Toon een foutmelding voor 'mobileNumber'
            binding.mobileNumber.error = "Please input your mobile phone number. Limit of 12 numbers."
            return
        }

        val newProfile = Profile(
            firstname, lastname, city, email, age, skillOne, certificate, mobileNumber,
            userId,
            true, 0
        )

        if (profile == null) {
            // Als profile null is, is het een nieuw profiel
            profileViewModel.addProfile(newProfile)

            // Toon een succesbericht met een Toast
            showToast("Your profile has been created!")

        } else {
            // Update het bestaande profiel met de juiste userId
            profile!!.userId = userId
            profile!!.firstname = firstname
            profile!!.lastname = lastname
            profile!!.age = age
            profile!!.email = email
            profile!!.city = city
            profile!!.skillOne = skillOne
            profile!!.certificate = certificate
            profile!!.mobileNumber = mobileNumber
            profileViewModel.updateProfile(profile!!)

            // Toon een succesbericht met een Toast
            showToast("Profile edit has been saved!")
        }

        binding.firstName.setText("")
        binding.lastName.setText("")
        binding.age.setText("")
        binding.email.setText("")
        binding.city.setText("")
        binding.skillOne.setText("")
        binding.certificate.setText("")
        binding.mobileNumber.setText("")
        dismiss()
    }
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}