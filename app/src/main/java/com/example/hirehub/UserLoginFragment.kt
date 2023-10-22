package com.example.hirehub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.FragmentUserLoginBinding
import com.example.hirehub.models.User
import com.example.hirehub.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserLoginFragment : Fragment() {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var buttonRedirectSignUp: Button
    lateinit var loginBackButton: Button

    private lateinit var binding: FragmentUserLoginBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialisatie van de binding en het inflaten van de fragment-layout
        binding = FragmentUserLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialisatie van de sessionmanager
        sessionManager = SessionManager(requireContext())

        etUsername = binding.etUsername
        etPassword = binding.etPassword
        btnLogin = binding.btnLogin
        buttonRedirectSignUp = binding.buttonRedirectSignUp
        loginBackButton = binding.loginBackButton

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (validateInputs(username, password)) {
                performLogin(username, password)
            } else {
                Toast.makeText(requireContext(), "Vul alle velden correct in.", Toast.LENGTH_SHORT).show()
            }
        }

        buttonRedirectSignUp.setOnClickListener() {
            val intent = Intent(requireContext(), RegistrationActivity::class.java)
            startActivity(intent)
        }

        loginBackButton.setOnClickListener {
            // Teruggaan naar het vorige scherm
            requireActivity().finish()
        }
    }

    private fun validateInputs(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }

    private fun performLogin(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val app = requireActivity().application as? HireHubApplication ?: return@launch
            val userRepository = app.userRepository
            val user = userRepository.getUserByUsernameAndPassword(username, password)

            if (user != null) {
                // Inloggen is geslaagd
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        requireContext(),
                        "Inloggen succesvol!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                // Gegevens opslaan in de SessionManager
                sessionManager.saveUserDetails(user.id, user.userRole, user.username, user.password)

                // Intent om door te sturen naar MainActivity
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                // Inloggen is mislukt
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        requireContext(),
                        "Ongeldige inloggegevens.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
