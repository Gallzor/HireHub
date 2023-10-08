package com.example.hirehub.databases

import android.app.Application
import com.example.hirehub.repositories.ProfileRepository
import com.example.hirehub.repositories.UserRepository

//NOTE: Hirehub is de naam van het project.
class HireHubApplication : Application() {

    // Initialisatie van de userDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val userDatabase by lazy { UserDatabase.getDatabase(this) }

    // Initialisatie van de userRepository met de userDatabase
    val userRepository by lazy { UserRepository(userDatabase.userDao()) }

    // Initialisatie van de profileDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val profileDatabase by lazy { ProfileDatabase.getDatabase(this) }

    // Initialisatie van de profileRepository met de profileDatabase
    val profileRepository by lazy { ProfileRepository(profileDatabase.profileDao()) }
}
