package com.example.hirehub.clicklisteners

import com.example.hirehub.models.Profile

// Een interface voor het definiëren van een click listener voor acties met betrekking tot profielitems in het profieloverzicht.
interface ProfileboardClickListener {
    // Een functie om te reageren op een klikgebeurtenis voor het bewerken van een profiel.
    fun editProfile(profile: Profile)

    // Een functie om te reageren op een klikgebeurtenis voor het verwijderen van een profiel.
    fun deleteProfile(profile: Profile)

    // Een functie om te reageren op een klikgebeurtenis voor het wijzigen van de zichtbaarheid van een profiel.
    fun toggleVisibility(profile: Profile)
}