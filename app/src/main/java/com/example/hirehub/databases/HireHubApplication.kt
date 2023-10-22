package com.example.hirehub.databases

import android.app.Application
import com.example.hirehub.repositories.ProfileRepository
import com.example.hirehub.repositories.UserRepository
import com.example.hirehub.utils.SessionManager
import com.example.hirehub.viewmodels.ProfileViewModel
import com.example.hirehub.viewmodels.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HireHubApplication : Application() {

    private val sessionManager: SessionManager by lazy {
        // Initialize your session manager here
        SessionManager(this)
    }

    // Lazy-initialisatie van de HireHubDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val database by lazy { HireHubDatabase.getDatabase(this) }

    // Lazy-initialisatie van de repositories door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    val userRepository by lazy { UserRepository(database.userDao(), database) }
    val profileRepository by lazy { ProfileRepository(database.profileDao(), database) }

    override fun onCreate() {
        super.onCreate()

        // Initialisatie van UserViewModel en ProfileViewModel
        val userViewModel = UserViewModel(userRepository)
        val profileViewModel = ProfileViewModel(profileRepository)

        val context = this

        // Voer de seeding uit als de gegevens nog niet in de database staan
        GlobalScope.launch(Dispatchers.IO) {
            if (!userViewModel.usersExist() && !profileViewModel.profilesExist()) {
                userViewModel.seedDatabase()
                profileViewModel.seedProfileDatabase()
            }
        }
    }
}
