package com.example.hirehub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.hirehub.databinding.FragmentProfileListViewSheetBinding
import com.example.hirehub.models.Profile
import com.example.hirehub.utils.SessionManager

class ProfileListViewSheetFragment : DialogFragment() {
    private var _binding: FragmentProfileListViewSheetBinding? = null
    private val binding get() = _binding!!
    private lateinit var sessionManager: SessionManager
    private var profile: Profile? = null

    fun setProfile(profile: Profile) {
        this.profile = profile
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileListViewSheetBinding.inflate(inflater, container, false)
        sessionManager = SessionManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loggedIn = sessionManager.getUserId() != -1

        profile?.let {
            // Vul de gegevens van 'profile' in de weergave in
            binding.firstName.text = it.firstname
            binding.lastName.text = it.lastname
            binding.age.text = it.age

            if (loggedIn) {
                binding.email.text = it.email
                binding.mobileNumber.text = it.mobileNumber
            } else {
                binding.email.text = "Log in to view"
                binding.mobileNumber.text = "Log in to view"
            }
            binding.city.text = it.city
            binding.skillOne.text = it.skillOne
            binding.certificate.text = it.certificate
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}