package com.example.hirehub.UserProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirehub.databinding.FragmentNewProfileSheetBinding
import com.example.hirehub.databinding.FragmentNewUserProfileSheetBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.viewmodels.ProfileViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewUserProfileSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewUserProfileSheetBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveUserProfileButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewUserProfileSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun saveAction() {
        val firstname = binding.firstName.text.toString()
        val lastname = binding.lastName.text.toString()
        val age = binding.age.text.toString()
        val city = binding.city.text.toString()
        val email = binding.email.text.toString()
        val skillOne = binding.skillOne.text.toString()
        val certificate = binding.certificate.text.toString()
        val mobileNumber = binding.mobileNumber.text.toString()

        // Assuming you have a function to save the profile in your ViewModel
        profileViewModel.addProfile(Profile(firstname, lastname, city, email, age, skillOne, certificate, mobileNumber, null, true, 0))

        // Clear the fields after saving
        binding.firstName.setText("")
        binding.lastName.setText("")
        binding.age.setText("")
        binding.email.setText("")
        binding.city.setText("")
        binding.skillOne.setText("")
        binding.certificate.setText("")
        binding.mobileNumber.setText("")

        // Dismiss the bottom sheet
        dismiss()
    }
}