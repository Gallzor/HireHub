package com.example.hirehub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirehub.Profileboard.ProfileboardActivity
import com.example.hirehub.Userboard.UserboardActivity
import com.example.hirehub.databinding.FragmentLandingtestBinding

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Opruimen van de binding om geheugenlekken te voorkomen
        _binding = null
    }
}
