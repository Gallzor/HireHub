package com.example.hirehub.UserProfile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hirehub.Profileboard.DeleteProfileSheetFragment
import com.example.hirehub.Profileboard.NewProfileSheetFragment
import com.example.hirehub.adapters.ProfileboardAdapter
import com.example.hirehub.clicklisteners.ProfileboardClickListener
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityProfileboardBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserprofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.newUserProfileButton.setOnClickListener {
            createNewProfile()
        }

        binding.newUserProfileButton.setOnClickListener {
            finish()
        }

        setRecyclerView()
    }

    private fun setRecyclerView() {
        profileAdapter = ProfileboardAdapter(emptyList(), this)
        binding.UserProfileRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = profileAdapter
        }
    }

    private fun createNewProfile() {
        // Hier kun je logica toevoegen om een nieuw profiel aan te maken
        // Je kunt bijvoorbeeld een dialoogvenster weergeven of een nieuw fragment toevoegen
        // waar de gebruiker de details van het nieuwe profiel kan invoeren.
        NewProfileSheetFragment(null).show(supportFragmentManager, "newProfileTag")
    }

    override fun editProfile(profile: Profile) {
        NewUserProfileSheetFragment(profile).show(supportFragmentManager, "newProfileTag")
    }

    override fun deleteProfile(profile: Profile) {
        DeleteUserProfileSheetFragment(profile).show(supportFragmentManager, "deleteProfileTag")
    }

    override fun toggleVisibility(profile: Profile) {
        profileViewModel.toggleProfileVisibility(profile)
    }
}