package com.example.hirehub.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirehub.models.User
import com.example.hirehub.repositories.UserRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers

class UserViewModel(private val repository: UserRepository): ViewModel() {
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

    // Seed de database en stopt er 3 voorafgemaakte accounts in, ieder van elke beschikbare rol.
    fun seedDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            // Gebruik de eerder gedefinieerde `repository` in plaats van `userRepository`
            val userRepository = repository

            // Check of de specifieke gebruikers al in de database zitten
            val henkExists =
                userRepository?.getUserByUsernameAndPassword("Henk", "Sollicitant1234") != null
            val lisanneExists =
                userRepository?.getUserByUsernameAndPassword("Lisanne", "Recruiter1234") != null
            val willemExists =
                userRepository?.getUserByUsernameAndPassword("Willem", "Admin1234") != null

            // Voeg alleen de specifieke gebruikers toe als ze nog niet bestaan
            if (!henkExists) {
                userRepository?.insertUser(User("Henk", "Sollicitant1234", "SOL"))
            }
            if (!lisanneExists) {
                userRepository?.insertUser(User("Lisanne", "Recruiter1234", "REC"))
            }
            if (!willemExists) {
                userRepository?.insertUser(User("Willem", "Admin1234", "AD"))
            }
        }
    }
}
