package com.example.hirehub.clicklisteners

// Een click listener-interface specifiek voor het gebruikersbord
import com.example.hirehub.models.User

interface UserboardClickListener
{
    // Functie die wordt aangeroepen wanneer een gebruiker bewerkt moet worden
    fun editUser(user: User)

    // Functie die wordt aangeroepen wanneer een gebruiker verwijderd moet worden
    fun deleteUser(user: User)
}
