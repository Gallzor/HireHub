package com.example.hirehub.databases

import android.app.Application
import com.example.hirehub.repositories.ProfileRepository
import com.example.hirehub.repositories.UserRepository

//NOTE: Hirehub is de naam van het projecct.
class HireHubApplication : Application() {
    // Lazy-initialisatie van de UserDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val userDatabase by lazy { UserDatabase.getDatabase(this) }

    // Lazy-initialisatie van de UserRepository door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    val userRepository by lazy { UserRepository(userDatabase.userDao()) }

    // Lazy-initialisatie van de UserDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val profileDatabase by lazy { ProfileDatabase.getDatabase(this) }

    // Lazy-initialisatie van de UserRepository door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    val profileRepository by lazy { ProfileRepository(profileDatabase.profileDao()) }

}
