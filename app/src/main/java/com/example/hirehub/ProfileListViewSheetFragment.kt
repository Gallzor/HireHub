package com.example.hirehub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.hirehub.databinding.FragmentProfileListViewSheetBinding
import com.example.hirehub.models.Profile

class ProfileListViewSheetFragment : DialogFragment() {
    private var _binding: FragmentProfileListViewSheetBinding? = null
    private val binding get() = _binding!!

    private var profile: Profile? = null

    fun setProfile(profile: Profile) {
        this.profile = profile
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileListViewSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profile?.let {
            // Vul de gegevens van 'profile' in de weergave in
            binding.firstName.text = it.firstname
            binding.lastName.text = it.lastname
            binding.age.text = it.age
            binding.mobileNumber.text = it.mobileNumber
            binding.city.text = it.city
            binding.skillOne.text = it.certificate
            binding.email.text = it.email
            binding.certificate.text = it.certificate
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}