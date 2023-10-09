package com.example.hirehub


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (validateInputs(username, password)) {
                CoroutineScope(Dispatchers.IO).launch {
                    val newUser = User(username, password)
                    saveUser(newUser)
                }
                Toast.makeText(this, "Registratie succesvol!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Vul alle velden correct in.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }

    private suspend fun saveUser(user: User) {
        val app = application as? HireHubApplication ?: return
        val userRepository = app.userRepository
        userRepository.insertUser(user)
    }

}
