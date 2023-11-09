package com.example.hirehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hirehub.R // Vervang 'com.example.hirehub' door de daadwerkelijke naam van je app
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChangePasswordActivity : AppCompatActivity() {

    lateinit var etOldPassword: EditText
    lateinit var etNewPassword: EditText
    lateinit var btnSave: Button
    lateinit var btnCancel: Button
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        etOldPassword = findViewById(R.id.etOldPassword)
        etNewPassword = findViewById(R.id.etNewPassword)
        btnSave = findViewById(R.id.btnSave)
        btnCancel = findViewById(R.id.btnCancel)
        sessionManager = SessionManager(this)

        btnSave.setOnClickListener {
            val oldPassword = etOldPassword.text.toString()
            val newPassword = etNewPassword.text.toString()

            if (validateInputs(oldPassword, newPassword)) {
                val userId = sessionManager.getUserId()

                if (userId != -1) {
                    CoroutineScope(Dispatchers.IO).launch {
                        val app = application as? HireHubApplication ?: return@launch
                        val userRepository = app.userRepository

                        // Voer hier de logica uit om het wachtwoord te wijzigen
                        // Roep een functie aan in UserRepository om het wachtwoord te wijzigen
                        // Pas de wachtwoordwijziging aan volgens jouw vereisten
                        // Bijvoorbeeld:
                        val user = userRepository.getUserById(userId)
                        if (user != null && user.password == oldPassword) {
                            user.password = newPassword
                            userRepository.updateUser(user)
                        } else {
                            runOnUiThread {
                                Toast.makeText(
                                    this@ChangePasswordActivity,
                                    "Error: Incorrect old password.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            return@launch
                        }

                        runOnUiThread {
                            Toast.makeText(
                                this@ChangePasswordActivity,
                                "Password is changed!.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        // Stuur de gebruiker terug naar de AccountActivity
                        val intent = Intent(this@ChangePasswordActivity, AccountActivity::class.java)
                        startActivity(intent)
                        finish() // Optioneel: sluit de ChangePasswordActivity.
                    }
                } else {
                    Toast.makeText(this@ChangePasswordActivity, "User is not logged in.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@ChangePasswordActivity, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener {
            // Als de gebruiker annuleert, stuur ze terug naar de AccountActivity zonder wijzigingen aan te brengen.
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
            finish() // Optioneel: sluit de ChangePasswordActivity.
        }
    }

    private fun validateInputs(oldPassword: String, newPassword: String): Boolean {
        return oldPassword.isNotEmpty() && newPassword.isNotEmpty()
    }
}
