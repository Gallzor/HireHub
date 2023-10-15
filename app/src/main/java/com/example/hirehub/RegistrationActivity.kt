package com.example.hirehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityLoginBinding
import com.example.hirehub.databinding.ActivityRegistrationBinding
import com.example.hirehub.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnRegister: Button
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Initialisatie van de binding
        binding = ActivityRegistrationBinding.inflate(layoutInflater)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (validateInputs(username, password)) {
                CoroutineScope(Dispatchers.IO).launch {
                    val newUser = User(username, password)
                    saveUser(newUser)

                    runOnUiThread {
                        Toast.makeText(this@RegistrationActivity, "Registratie succesvol!", Toast.LENGTH_SHORT).show()
                        navigateToLogin()
                    }
                }
            } else {
                Toast.makeText(this, "Vul alle velden correct in.", Toast.LENGTH_SHORT).show()
            }
            // Koppelen van klikactie aan de loginBackButton
            binding.registrationBackButton.setOnClickListener {
                finish() // Dit zal teruggaan naar het vorige scherm
            }

        }
    }

    private fun validateInputs(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }

    private suspend fun saveUser(user: User) {
        val app = application as? HireHubApplication ?: return
        val userRepository = app.userRepository
        userRepository.insertUser(user)
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Optioneel: sluit de huidige registratieactiviteit
    }
}
