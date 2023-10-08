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

class EditProfileSheetFragment(private val profile: Profile) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewProfileSheetBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileboardTitle.text = "Edit Profile"

        val editable = Editable.Factory.getInstance()
        binding.firstName.text = editable.newEditable(profile.firstname)
        binding.lastName.text = editable.newEditable(profile.lastname)
        binding.city.text = editable.newEditable(profile.city)
        binding.age.text = editable.newEditable(profile.age)
        binding.email.text = editable.newEditable(profile.email)
        binding.certificate.text = editable.newEditable(profile.certificate)
        binding.skillOne.text = editable.newEditable(profile.skillOne)
        binding.mobileNumber.text = editable.newEditable(profile.mobileNumber)

        // ViewModel aanmaken voor profielsacties
        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
        binding.saveProfileButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewProfileSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun saveAction() {
        val firstname = binding.firstName.text.toString()
        val lastname = binding.lastName.text.toString()
        val city = binding.city.text.toString()
        val age = binding.age.text.toString()
        val mobilenumber = binding.mobileNumber.text.toString()
        val certificate = binding.certificate.text.toString()
        val skillone = binding.skillOne.text.toString()
        val email = binding.email.text.toString()

        // Bestaande profiel bijwerken met de nieuwe gegevens
        profile.firstname = firstname
        profile.lastname = lastname
        profile.city = city
        profile.age = age
        profile.email = email
        profile.mobileNumber = mobilenumber
        profile.certificate = certificate
        profile.skillOne = skillone
        profileViewModel.updateProfile(profile)

        // Tekstvelden legen en het bottom sheet sluiten
        binding.firstName.setText("")
        binding.lastName.setText("")
        binding.city.setText("")
        binding.email.setText("")
        binding.mobileNumber.setText("")
        binding.certificate.setText("")
        binding.skillOne.setText("")
        binding.age.setText("")
        dismiss()
    }
}
