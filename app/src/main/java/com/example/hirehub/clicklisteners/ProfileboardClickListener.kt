package com.example.hirehub.clicklisteners

// Een click listener-interface specifiek voor het profielbord
import com.example.hirehub.models.Profile

interface ProfileboardClickListener {

    // Functie die wordt aangeroepen wanneer een profiel bewerkt moet worden
    fun editProfile(profile: Profile)

    // Functie die wordt aangeroepen wanneer een profiel verwijderd moet worden
    fun deleteProfile(profile: Profile)
}
