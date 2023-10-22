package com.example.hirehub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.hirehub.Profileboard.ProfileboardActivity
import com.example.hirehub.UserProfile.UserProfileActivity
import com.example.hirehub.Userboard.UserboardActivity
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityMainBinding
import com.example.hirehub.factories.UserModelFactory
import com.example.hirehub.utils.SessionManager
import com.example.hirehub.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionManager: SessionManager

    private val userViewModel: UserViewModel by viewModels {
        UserModelFactory((application as HireHubApplication).userRepository)
    }

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Maak 3 gebruikers aan en seed ze in de database.
        // Roep de seedDatabase-functie aan wanneer de app wordt gestart
        userViewModel.seedDatabase()

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

            // Verberg de knoppen
            val userCrudButton = findViewById<ImageButton>(R.id.userCrudButton)
            val profileCrudButton = findViewById<ImageButton>(R.id.profileCrudButton)
            userCrudButton.visibility = View.GONE
            profileCrudButton.visibility = View.GONE
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
                "sol", "sollicitant", "sol" -> {
                    // Gebruiker is een sollicitant
                    userCrudButton.visibility = View.GONE
                    profileCrudButton.setOnClickListener {
                        val intent = Intent(this, UserProfileActivity::class.java)
                        startActivity(intent)
                    }
                }

                "rec", "recruiter", "rec" -> {
                    // Gebruiker is een recruiter
                    userCrudButton.visibility = View.GONE
                    profileCrudButton.setOnClickListener {
                        val intent = Intent(this, ProfileboardActivity::class.java)
                        startActivity(intent)
                    }
                }

                "ad", "admin", "ad" -> {
                    // Gebruiker is een admin
                    // Toon de userCrudButton en stuur profileCrudButton naar ProfileboardActivity
                    userCrudButton.visibility = View.VISIBLE
                    userCrudButton.setOnClickListener {
                        val intent = Intent(this, UserboardActivity::class.java)
                        startActivity(intent)
                    }
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
