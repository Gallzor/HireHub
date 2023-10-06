package com.example.hirehub.databases

import android.app.Application
import com.example.hirehub.repositories.UserRepository

//NOTE: Hirehub is de naam van het projecct.
class HireHubApplication : Application() {
    // Lazy-initialisatie van de UserDatabase door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    private val database by lazy { UserDatabase.getDatabase(this) }

    // Lazy-initialisatie van de UserRepository door de getter aan te roepen wanneer deze voor het eerst wordt opgevraagd
    val repository by lazy { UserRepository(database.userDao()) }
}
