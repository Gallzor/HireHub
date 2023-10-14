package com.example.hirehub.databases

import android.app.Application
import com.example.hirehub.repositories.ProfileRepository
import com.example.hirehub.repositories.UserRepository

class HireHubApplication : Application() {
    // Lazy-initialisatie van de HireHubDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val database by lazy { HireHubDatabase.getDatabase(this) }

    // Lazy-initialisatie van de repositories door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    val userRepository by lazy { UserRepository(database.userDao()) }
    val profileRepository by lazy { ProfileRepository(database.profileDao()) }
}
