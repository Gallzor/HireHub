package com.example.hirehub.clicklisteners

import com.example.hirehub.models.User

// Een interface voor het definiëren van een click listener voor acties met betrekking tot gebruikersitems in het gebruikersoverzicht.
interface UserboardClickListener {
    // Een functie om te reageren op een klikgebeurtenis voor het bewerken van een gebruiker.
    fun editUser(user: User)

    // Een functie om te reageren op een klikgebeurtenis voor het verwijderen van een gebruiker.
    fun deleteUser(user: User)
}