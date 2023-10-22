package com.example.hirehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.LoginActivity
import com.example.hirehub.R
import com.example.hirehub.utils.SessionManager
import com.example.hirehub.repositories.UserRepository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        sessionManager = SessionManager(this)

        val btnChangePassword = findViewById<Button>(R.id.btnChangePassword)
        val btnDeleteAccount = findViewById<Button>(R.id.btnDeleteAccount)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnChangePassword.setOnClickListener {
            // Navigeer naar het wachtwoordwijzigingsscherm
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        btnDeleteAccount.setOnClickListener {
            // Voeg hier de logica toe om het account te verwijderen
            val userId = sessionManager.getUserId()
            if (userId != -1) {
                deleteUserAccount(userId)
            }
        }

        btnLogout.setOnClickListener {
            sessionManager.clearUserDetails() // Sessie wissen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun deleteUserAccount(userId: Int) {
        val app = application as? HireHubApplication ?: return
        val userRepository = app.userRepository
        val profileRepository = app.profileRepository
        val username = sessionManager.getUsername()
        val password = sessionManager.getPassword() // Verkrijg het wachtwoord op een veilige manier

        if (username != null && password != null) {
            val user = userRepository.getUserByUsernameAndPassword(username, password)

            if (user != null) {
                userRepository.deleteUser(user)

                val profile = profileRepository.getProfileByUserId(userId).value
                if (profile != null) {
                    profileRepository.deleteProfile(profile)
                }

                Toast.makeText(this, "Account verwijderd.", Toast.LENGTH_SHORT).show()
                sessionManager.clearUserDetails() // Sessie wissen
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Fout bij het verwijderen van het account.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Gebruikersnaam of wachtwoord ontbreekt.", Toast.LENGTH_SHORT).show()
        }
    }
}
