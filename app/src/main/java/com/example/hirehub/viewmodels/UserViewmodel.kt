package com.example.hirehub.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirehub.models.User
import com.example.hirehub.repositories.UserRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

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
        GlobalScope.launch(Dispatchers.IO) {
            val userRepository = repository

            val usersToAdd = listOf(
                User("KopjeKoffie", "Sollicitant1234", "SOL"),
                User("PindaReep", "Recruiter1234", "REC"),
                User("Kauwgumpje", "Admin1234", "AD"),
                User("BakjeThee", "1435SDFsd8", "SOL"),
                User("Lantaarn", "5634SDF", "SOL"),
                User("GekVogeltje", "02394Adas", "SOL"),
                User("Chocomelk", "23jdsf#@fk", "SOL"),
                User("AutoVrouw", "2kd@#fk1", "SOL"),
                User("BloemenMeisje", "9823DSf2", "SOL")
            )
            // Voeg de lijst van gebruikers toe aan de database
            userRepository?.addUsersWithTransaction(usersToAdd)

        }
    }

    fun usersExist(): Boolean {
        return repository.usersExist()
    }
}
