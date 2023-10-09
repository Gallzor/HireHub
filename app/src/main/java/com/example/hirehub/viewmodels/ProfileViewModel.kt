package com.example.hirehub.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirehub.models.User
import com.example.hirehub.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: UserRepository): ViewModel() {
    // LiveData voor het observeren van de lijst met gebruikers
    var users: LiveData<List<User>> = repository.allUsers

    // Functie om een nieuwe gebruiker toe te voegen aan de database
    fun addUser(newUser: User) {
        // Coroutine starten op IO-thread voor asynchrone databasebewerking
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(newUser)
        }
    }

    // Functie om een bestaande gebruiker bij te werken in de database
    fun updateUser(user: User) {
        // Coroutine starten op IO-thread voor asynchrone databasebewerking
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    //     Functie om een gebruiker te verwijderen uit de database
    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }
}
