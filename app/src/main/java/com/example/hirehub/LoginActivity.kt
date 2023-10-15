package com.example.hirehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityLoginBinding
import com.example.hirehub.models.User
import com.example.hirehub.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialisatie van de loginbinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        // Initialisatie van de sessionmanager
        sessionManager = SessionManager(this)


        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (validateInputs(username, password)) {
                CoroutineScope(Dispatchers.IO).launch {
                    // Haal de gebruiker op basis van de gebruikersnaam en wachtwoord
                    val app = application as? HireHubApplication ?: return@launch
                    val userRepository = app.userRepository
                    val user = userRepository.getUserByUsernameAndPassword(username, password)

                    // Controleer of de gebruiker is gevonden en wachtwoord overeenkomt
                    if (user != null) {
                        // Inloggen is geslaagd
                        runOnUiThread {
                            Toast.makeText(
                                this@LoginActivity,
                                "Inloggen succesvol!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        // Gegevens opslaan in de SessionManager
                        sessionManager.saveUserDetails(user.id, user.userRole, user.username)

                        // Intent om door te sturen naar MainActivity
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Optioneel: sluit de LoginActivity

                    } else {
                        runOnUiThread {
                            // Inloggen is mislukt
                            Toast.makeText(
                                this@LoginActivity,
                                "Ongeldige inloggegevens.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Vul alle velden correct in.", Toast.LENGTH_SHORT).show()
            }

            // Koppelen van klikactie aan de loginBackButton
            binding.loginBackButton.setOnClickListener {
                finish() // Dit zal teruggaan naar het vorige scherm
            }
        }

    }

    private fun validateInputs(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}
