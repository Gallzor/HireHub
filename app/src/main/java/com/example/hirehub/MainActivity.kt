package com.example.hirehub

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.hirehub.databinding.ActivityMainBinding
import com.example.hirehub.utils.SessionManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialiseer de SessionManager
        sessionManager = SessionManager(this)

        // Zoek de accountButton en voeg een kliklistener toe
        val accountButton = findViewById<View>(R.id.accountButton)

        if (sessionManager.getUserId() == -1) {
            // Er is geen gebruiker ingelogd, stuur door naar LoginActivity
            accountButton.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        } else {
            // Er is een gebruiker ingelogd, stuur door naar AccountActivity
            accountButton.setOnClickListener {
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
