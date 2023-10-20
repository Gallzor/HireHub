package com.example.hirehub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirehub.Profileboard.ProfileboardActivity
import com.example.hirehub.UserProfile.UserProfileActivity
import com.example.hirehub.Userboard.UserboardActivity
import com.example.hirehub.databinding.FragmentLandingtestBinding
import com.example.hirehub.utils.SessionManager

class landingtestFragment : Fragment() {

    private var _binding: FragmentLandingtestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingtestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Koppelen van klikactie aan de userboardButton
        binding.userboardButton.setOnClickListener {
            // Starten van UserboardActivity wanneer de button wordt geklikt
            val intent = Intent(requireActivity(), UserboardActivity::class.java)
            startActivity(intent)
        }

        // Koppelen van klikactie aan de profileButton
        binding.profileboardButton.setOnClickListener {
            // Starten van ProfileboardActivity wanneer de button wordt geklikt
            val intent = Intent(requireActivity(), ProfileboardActivity::class.java)
            startActivity(intent)

        }
        // Koppelen van klikactie aan de RegistratieButton
        binding.registrationButton.setOnClickListener {
            // Starten van RegistationActivity wanneer de button wordt geklikt
            val intent = Intent(requireActivity(), RegistrationActivity::class.java)
            startActivity(intent)

        }

        // Koppelen van klikactie aan de loginButton
        binding.loginButton.setOnClickListener {
            // Starten van LoginActivity wanneer de button wordt geklikt
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
        }

        // Koppelen van klikactie aan de loginButton
        binding.userProfileButton.setOnClickListener {
            // Starten van LoginActivity wanneer de button wordt geklikt
            val intent = Intent(requireActivity(), UserProfileActivity::class.java)
            startActivity(intent)
        }

        // Haal de gebruikersnaam op uit de SessionManager
        val sessionManager = SessionManager(requireContext())
        val username = sessionManager.getUsername()

        // Update de welkomsttekst met de gebruikersnaam
        binding.welcomeUsername.text = "Hello, $username"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Opruimen van de binding om geheugenlekken te voorkomen
        _binding = null
    }
}
