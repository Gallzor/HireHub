package com.example.hirehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.models.Profile
import com.example.hirehub.models.User
import com.example.hirehub.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountActivity : AppCompatActivity() {

    lateinit var btnUpdateProfile: Button
    lateinit var btnDeleteProfile: Button
    lateinit var btnUpdateUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Initialisatie van UI elementen
        btnUpdateProfile = findViewById(R.id.btnUpdateProfile)
        btnDeleteProfile = findViewById(R.id.btnDeleteProfile)
        btnUpdateUser = findViewById(R.id.btnUpdateUser)

        // Haalt de huidige gebruiker ID uit de SessionManager
        val sessionManager = SessionManager(this)
        val userId = sessionManager.getUserId()

        // Update profiel knop logica
        btnUpdateProfile.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val app = application as? HireHubApplication ?: return@launch
                val profileRepository = app.profileRepository

                // Zoekt naar het profiel dat bij de huidige gebruiker hoort
                val profileToUpdate = profileRepository.allProfiles.value?.firstOrNull { it.userId == userId }

                // Voer de gewenste updates uit op het profielobject (als voorbeeld)
                if (profileToUpdate != null) {
                    // Bijvoorbeeld:
                    // profileToUpdate.firstname = "Nieuwe voornaam"
                    profileRepository.updateProfile(profileToUpdate)
                    showToast("Profiel succesvol bijgewerkt!")
                } else {
                    showToast("Profiel niet gevonden!")
                }
            }
        }

        // Verwijder profiel knop logica
        btnDeleteProfile.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val app = application as? HireHubApplication ?: return@launch
                val profileRepository = app.profileRepository

                // Zoekt naar het profiel dat bij de huidige gebruiker hoort
                val profileToDelete = profileRepository.allProfiles.value?.firstOrNull { it.userId == userId }

                if (profileToDelete != null) {
                    profileRepository.deleteProfile(profileToDelete)
                    showToast("Profiel succesvol verwijderd!")
                } else {
                    showToast("Profiel niet gevonden!")
                }
            }
        }

        // Update gebruiker knop logica
        btnUpdateUser.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val app = application as? HireHubApplication ?: return@launch
                val userRepository = app.userRepository

                // Haalt de gebruiker op basis van zijn/haar ID
                val userToUpdate = userRepository.getUserById(userId)

                if (userToUpdate != null) {
                    // Voer de gewenste updates uit op het userobject (als voorbeeld)
                    // Bijvoorbeeld:
                    // userToUpdate.username = "Nieuwe gebruikersnaam"
                    userRepository.updateUser(userToUpdate)
                    showToast("Gebruikersinfo succesvol bijgewerkt!")
                } else {
                    showToast("Gebruiker niet gevonden!")
                }
            }
        }
    }

    /**
     * Functie om een toast bericht te tonen op het scherm.
     * @param message Het bericht dat getoond moet worden.
     */
    private fun showToast(message: String) {
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(this@AccountActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}
