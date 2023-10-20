package com.example.hirehub.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SessionManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val SHARED_PREF_NAME = "user_session"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_ROLE = "userRole"
        private const val KEY_USERNAME = "username"
        private const val KEY_USER_PASSWORD = "password"
    }

    // Functie om alle gebruikersgegevens op te slaan
    fun saveUserDetails(userId: Int, userRole: String, username: String, password: String) {
        with(sharedPreferences.edit()) {
            putInt(KEY_USER_ID, userId)
            putString(KEY_USER_ROLE, userRole)
            putString(KEY_USERNAME, username)
            putString(KEY_USER_PASSWORD, password)
            apply()
        }

        Log.d("SessionManager", "User details saved: ID-$userId, Role-$userRole, Username-$username")
    }

    // Functie om de gebruikers-ID op te halen
    fun getUserId(): Int {
        return sharedPreferences.getInt(KEY_USER_ID, -1)
    }

    // Functie om de gebruikersrol op te halen
    fun getUserRole(): String? {
        return sharedPreferences.getString(KEY_USER_ROLE, null)
    }

    // Functie om de gebruikersnaam op te halen
    fun getUsername(): String? {
        return sharedPreferences.getString(KEY_USERNAME, null)
    }

    // Functie om het wachtwoord van de gebruiker op te halen (meestal is het niet aan te raden het wachtwoord in de voorkeuren op te slaan voor veiligheidsredenen,
    // maar ik voeg het hier toe voor de volledigheid. Overweeg het gebruik van beveiligde opslagmechanismen voor wachtwoorden zoals Android Keystore)
    fun getPassword(): String? {
        return sharedPreferences.getString(KEY_USER_PASSWORD, null)
    }

    // Een functie om alle gebruikersdetails te wissen (bijvoorbeeld bij uitloggen)
    fun clearUserDetails() {
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
    }
}
