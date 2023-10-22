package com.example.hirehub

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.hirehub.Profileboard.ProfileboardActivity
import com.example.hirehub.UserProfile.UserProfileActivity
import com.example.hirehub.Userboard.UserboardActivity
import com.example.hirehub.databinding.ActivityMainBinding
import com.example.hirehub.utils.SessionManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialiseer de SessionManager
        sessionManager = SessionManager(this)

        // Haal de gebruikersrol en het gebruikers-ID op
        val userRole = sessionManager.getUserRole()
        val userId = sessionManager.getUserId()

        // Zoek de accountButton en voeg een kliklistener toe
        val accountButton = findViewById<View>(R.id.accountButton)

        if (userId == -1) {
            // Er is geen gebruiker ingelogd, stuur door naar LoginActivity
            accountButton.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        } else {
            // Er is een gebruiker ingelogd, stuur door naar AccountActivity
            accountButton.setOnClickListener {
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
            }

            // Zoek de knoppen
            val homepageButton = findViewById<ImageButton>(R.id.homepageButton)
            val userCrudButton = findViewById<ImageButton>(R.id.userCrudButton)
            val profileCrudButton = findViewById<ImageButton>(R.id.profileCrudButton)

            // Logica voor knoppen op basis van gebruikersrol
            when (userRole?.toLowerCase()) {
                "sol", "sollicitant" -> {
                    // Gebruiker is een sollicitant
                    userCrudButton.visibility = View.GONE
                    profileCrudButton.setOnClickListener {
                        val intent = Intent(this, UserProfileActivity::class.java)
                        startActivity(intent)
                    }
                }
                "rec", "recruiter" -> {
                    // Gebruiker is een recruiter
                    userCrudButton.visibility = View.GONE
                    profileCrudButton.setOnClickListener {
                        val intent = Intent(this, ProfileboardActivity::class.java)
                        startActivity(intent)
                    }
                }
                "ad", "admin" -> {
                    // Gebruiker is een admin
                    // Toon de userCrudButton en stuur profileCrudButton naar ProfileboardActivity
                    userCrudButton.visibility = View.VISIBLE
                    profileCrudButton.setOnClickListener {
                        val intent = Intent(this, ProfileboardActivity::class.java)
                        startActivity(intent)
                    }
                }
                else -> {
                    // Gebruiker heeft een onbekende rol (toon geen knoppen)
                    userCrudButton.visibility = View.GONE
                    profileCrudButton.visibility = View.GONE
                }
            }
        }
    }
}