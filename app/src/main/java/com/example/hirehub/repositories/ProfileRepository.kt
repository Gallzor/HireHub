package com.example.hirehub.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.hirehub.daos.UserDao
import com.example.hirehub.models.User

class ProfileRepository (private val userDao: UserDao) {

    // LiveData voor het observeren van de lijst met alle gebruikers
    val allUsers: LiveData<List<User>> = userDao.allUsers()

    /**
     * Voegt een nieuwe gebruiker toe aan de database.
     * @param user De gebruiker die moet worden toegevoegd.
     */
    @WorkerThread
    //Dit is een annotatie die aangeeft dat de annotatie ervoor zorgt dat de functies die worden aangeroepen, uitgevoerd worden op een aparte achtergrondthread (niet op de main/UI-thread).
    // Dit is belangrijk om te voorkomen dat de UI bevriest of vertraagt bij zware taken.
    fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    /**
     * Werkt de gegevens van een bestaande gebruiker bij in de database.
     * @param user De gebruiker met bijgewerkte gegevens.
     */
    @WorkerThread
    fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    /**
     * Verwijdert een gebruiker uit de database.
     * @param user De gebruiker die moet worden verwijderd.
     */
    @WorkerThread
    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}
