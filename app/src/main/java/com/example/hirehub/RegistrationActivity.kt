package com.example.hirehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityLoginBinding
import com.example.hirehub.databinding.ActivityRegistrationBinding
import com.example.hirehub.models.User
import com.example.hirehub.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialiseer de SessionManager
        sessionManager = SessionManager(this)

    }
}

