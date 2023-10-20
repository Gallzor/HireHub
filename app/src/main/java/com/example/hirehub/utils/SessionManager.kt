package com.example.hirehub.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

//De sessionmanager neemt de gegevens van een (ingelogde) user mee,
//en op die manier kun je op een fragment of activity vertellen welke user op dat moment bezig is.
class SessionManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val SHARED_PREF_NAME = "user_session"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_ROLE = "userRole"
        private const val KEY_USERNAME = "username"
    }

    // Functie om gebruikersgegevens op te slaan
    fun saveUserDetails(userId: Int, userRole: String, username: String) {
        // Sla de gebruikersgegevens op in de gedeelde voorkeuren
        sharedPreferences.edit().putInt(KEY_USER_ID, userId).apply()
        sharedPreferences.edit().putString(KEY_USER_ROLE, userRole).apply()
        sharedPreferences.edit().putString(KEY_USERNAME, username).apply()

        // Voeg een logboekverklaring toe om de opgeslagen gegevens te controleren
        Log.d("SessionManager", "User details saved: $userId, $userRole, $username")
    }

    // Functie om de gebruikers-ID op te halen
    fun saveUserDetails(userId: Int) {
        sharedPreferences.edit().putInt(KEY_USER_ID, userId).apply()
    }

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
}
