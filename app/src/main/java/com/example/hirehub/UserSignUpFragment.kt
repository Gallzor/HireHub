package com.example.hirehub

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.FragmentUserSignupBinding
import com.example.hirehub.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserSignUpFragment : Fragment() {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnRegister: Button
    lateinit var buttonRedirectLogin: Button
    private lateinit var binding: FragmentUserSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialisatie van de binding en het inflaten van de fragment-layout
        binding = FragmentUserSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etUsername = binding.etUsername
        etPassword = binding.etPassword
        btnRegister = binding.btnRegister
        buttonRedirectLogin = binding.buttonRedirectLogin
        val registrationBackButton = binding.registrationBackButton

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (validateInputs(username, password)) {
                performRegistration(username, password)
            } else {
                Toast.makeText(requireContext(), "Vul alle velden correct in.", Toast.LENGTH_SHORT).show()
            }
        }

        buttonRedirectLogin.setOnClickListener() {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
        registrationBackButton.setOnClickListener {
            // Teruggaan naar het vorige scherm
            requireActivity().finish()
        }
    }

    private fun validateInputs(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }

    private fun performRegistration(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val newUser = User(username, password)
            saveUser(newUser)

            requireActivity().runOnUiThread {
                Toast.makeText(requireContext(), "Registratie succesvol!", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            }
        }
    }

    private fun saveUser(user: User) {
        val app = requireActivity().application as? HireHubApplication ?: return
        val userRepository = app.userRepository
        userRepository.insertUser(user)
    }

    private fun navigateToLogin() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Optioneel: sluit de huidige registratieactiviteit
    }
}
