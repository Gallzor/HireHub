package com.example.hirehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hirehub.databases.HireHubApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val btnChangePassword = findViewById<Button>(R.id.btnChangePassword)
        val btnDeleteAccount = findViewById<Button>(R.id.btnDeleteAccount)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnChangePassword.setOnClickListener {
            // Voeg hier logica toe voor het wijzigen van het wachtwoord
        }

        btnDeleteAccount.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                // Voeg hier logica toe voor het verwijderen van het account
            }
        }

        btnLogout.setOnClickListener {
            // Voeg hier logica toe voor uitloggen
        }
    }
}
