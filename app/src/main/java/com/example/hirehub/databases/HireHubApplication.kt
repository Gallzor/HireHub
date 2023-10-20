package com.example.hirehub.databases

import android.app.Application
import com.example.hirehub.repositories.ProfileRepository
import com.example.hirehub.repositories.UserRepository
import com.example.hirehub.utils.SessionManager

class HireHubApplication : Application() {

    private val sessionManager: SessionManager by lazy {
        // Initialize your session manager here
        SessionManager(this)
    }

    // Lazy-initialisatie van de HireHubDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val database by lazy { HireHubDatabase.getDatabase(this) }

    // Lazy-initialisatie van de repositories door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    val userRepository by lazy { UserRepository(database.userDao()) }
    val profileRepository by lazy { ProfileRepository(database.profileDao()) }
}
