package com.example.hirehub.clicklisteners

import com.example.hirehub.models.Profile

// Een interface voor het definiëren van een click listener voor profielitems in het hoofdprofieloverzicht.
interface MainProfileClickListener {
    // Een functie om te reageren op een klikgebeurtenis op een profielitem en het geselecteerde profiel door te geven.
    fun onProfileItemClick(profile: Profile)
}