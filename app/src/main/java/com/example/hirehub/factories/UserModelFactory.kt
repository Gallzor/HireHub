package com.example.hirehub.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.repositories.UserRepository
import com.example.hirehub.viewmodels.UserViewModel
import java.lang.IllegalArgumentException

class UserModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    // Functie om een ViewModel instantie aan te maken
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Controleer of het modelClass type compatibel is met UserViewModel
        if (modelClass.isAssignableFrom(UserViewModel::class.java))
            return UserViewModel(repository) as T // Geef een instantie van UserViewModel terug

        // Als het modelClass type niet compatibel is, gooi een IllegalArgumentException
        throw IllegalArgumentException("Unknown class for View Model")
    }
}
