package com.example.hirehub.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.repositories.ProfileRepository
import com.example.hirehub.repositories.UserRepository
import com.example.hirehub.viewmodels.ProfileViewModel
import com.example.hirehub.viewmodels.UserViewModel
import java.lang.IllegalArgumentException

class ProfileModelFactory (private val repository: ProfileRepository) : ViewModelProvider.Factory {
    // Functie om een ViewModel instantie aan te maken
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Controleer of het modelClass type compatibel is met ProfileViewModel
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java))
            return ProfileViewModel(repository) as T // Geef een instantie van ProfileViewModel terug

        // Als het modelClass type niet compatibel is, gooi een IllegalArgumentException
        throw IllegalArgumentException("Unknown class for View Model")
    }
}