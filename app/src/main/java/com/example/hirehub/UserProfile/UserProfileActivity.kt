package com.example.hirehub.UserProfile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hirehub.Profileboard.NewProfileSheetFragment
import com.example.hirehub.adapters.ProfileboardAdapter
import com.example.hirehub.adapters.UserProfileAdapter
import com.example.hirehub.clicklisteners.ProfileboardClickListener
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityUserprofileBinding
import com.example.hirehub.factories.ProfileModelFactory
import com.example.hirehub.models.Profile
import com.example.hirehub.utils.SessionManager
import com.example.hirehub.viewmodels.ProfileViewModel

class UserProfileActivity : AppCompatActivity(), ProfileboardClickListener {

    private lateinit var binding: ActivityUserprofileBinding
    private lateinit var profileAdapter: ProfileboardAdapter
    private lateinit var sessionManager: SessionManager
    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileModelFactory((application as HireHubApplication).profileRepository)
    }

    private var userProfile: Profile? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserprofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.newUserProfileButton.setOnClickListener {
            // Maak een nieuw profiel met de juiste gebruikers-ID
            val userId = sessionManager.getUserId()
            NewUserProfileSheetFragment(null).show(supportFragmentManager, "newUserProfileTag")
        }


        // Koppelen van klikactie aan de newProfileBackButton
        binding.newUserProfileBackButton.setOnClickListener {
            // Teruggaan naar het vorige scherm
            finish()
        }
        // Laat username zien
        showWelcomeProfileMessage()

        setRecyclerView()
        observeUserProfile()
    }

    private fun observeUserProfile() {
        val userId = sessionManager.getUserId()
        if (userId != null) {
            profileViewModel.getProfileByUserId(userId).observe(this, Observer { profile ->
                userProfile = profile
                updateUIBasedOnUserProfile()
            })
        }
    }

    private fun showWelcomeProfileMessage() {
        // Haal de gebruikersnaam op uit de SessionManager
        val sessionManager = SessionManager(this)
        val username = sessionManager.getUsername() ?: "Gebruiker"

        // Update de welkomsttekst met de gebruikersnaam in de UserProfile
        binding.titleWelcomeUserProfile.text = "Welkom, $username"
    }

    private fun updateUIBasedOnUserProfile() {
        if (userProfile == null) {
            binding.noProfileTextView.visibility = View.VISIBLE
            binding.UserProfileRecyclerView.visibility = View.GONE
            binding.noProfileTextView.text = "You don't have a profile yet."
        } else {
            binding.noProfileTextView.visibility = View.GONE
            binding.UserProfileRecyclerView.visibility = View.VISIBLE
            // Voer hier de logica uit om het profiel weer te geven in de UI
        }
    }

    private fun setRecyclerView() {
        val UserProfileActivity = this
        // Observeren van de profielenlijst in de ViewModel en het bijwerken van de RecyclerView-adapter wanneer er veranderingen zijn
        profileViewModel.profiles.observe(this) {
            binding.UserProfileRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = UserProfileAdapter(it, UserProfileActivity)
            }
        }
    }

    override fun editProfile(profile: Profile) {
        NewUserProfileSheetFragment(profile).show(supportFragmentManager, "newUserProfileTag")
    }

    override fun deleteProfile(profile: Profile) {
        DeleteUserProfileSheetFragment(profile).show(supportFragmentManager, "deleteUserProfileTag")
    }

    // Verandert de zichtbaarheid van een profiel in de profileboard
    override fun toggleVisibility(profile: Profile) {
        profileViewModel.toggleProfileVisibility(profile)
    }
}