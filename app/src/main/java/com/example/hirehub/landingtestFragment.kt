package com.example.hirehub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirehub.Userboard.UserboardActivity
import com.example.hirehub.databinding.FragmentLandingtestBinding

class landingtestFragment : Fragment() {

    private var _binding: landingtestFragment? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLandingtestBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLandingtestBinding.bind(view)  // Gebruik juiste binding
        binding.userboardButton.setOnClickListener {
            val intent = Intent(requireActivity(), UserboardActivity::class.java)
            startActivity(intent)
        }
    }
}