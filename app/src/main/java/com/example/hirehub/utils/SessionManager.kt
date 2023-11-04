package com.example.hirehub.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

/**
 * SessionManager is verantwoordelijk voor het beheren van de gebruikerssessie en het opslaan van gebruikersgegevens in SharedPreferences.
 * Deze klasse biedt methoden om gebruikersgegevens op te slaan, op te halen en te wissen.
 * @param context De context van de toepassing.
 */
class SessionManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val SHARED_PREF_NAME = "user_session"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_ROLE = "userRole"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
    }

    fun saveUserDetails(userId: Int, userRole: String, username: String, password: String) {
        sharedPreferences.edit()
            .putInt(KEY_USER_ID, userId)
            .putString(KEY_USER_ROLE, userRole)
            .putString(KEY_USERNAME, username)
            .putString(KEY_PASSWORD, password)
            .apply()
        Log.d("SessionManager", "User data has been saved: $userId, $userRole, $username, $password")
    }

    /**
     * Haal de gebruikers-ID op uit SharedPreferences.
     * @return De ID van de gebruiker of -1 als deze niet is opgeslagen.
     */
    fun getUserId(): Int {
        return sharedPreferences.getInt(KEY_USER_ID, -1)
    }

    /**
     * Haal de rol van de gebruiker op uit SharedPreferences.
     * @return De rol van de gebruiker of null als deze niet is opgeslagen.
     */

    fun getUserRole(): String? {
        return sharedPreferences.getString(KEY_USER_ROLE, null)
    }

    /**
     * Haal de gebruikersnaam op uit SharedPreferences.
     * @return De gebruikersnaam van de gebruiker of null als deze niet is opgeslagen.
     */
    fun getUsername(): String? {
        return sharedPreferences.getString(KEY_USERNAME, null)
    }

    fun getPassword(): String? {
        return sharedPreferences.getString(KEY_PASSWORD, null)
    }

    fun clearUserDetails() {
        sharedPreferences.edit().clear().apply()
    }
}