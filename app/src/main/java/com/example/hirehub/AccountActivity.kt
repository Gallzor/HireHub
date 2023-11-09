package com.example.hirehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.LoginActivity
import com.example.hirehub.R
import com.example.hirehub.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.appcompat.app.AlertDialog
class AccountActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        sessionManager = SessionManager(this)

        val btnChangePassword = findViewById<Button>(R.id.btnChangePassword)
        val accountBackButton = findViewById<Button>(R.id.accountBackButton)
        val btnDeleteAccount = findViewById<Button>(R.id.btnDeleteAccount)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnChangePassword.setOnClickListener {
            // Navigeer naar het wachtwoordwijzigingsscherm
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        // Koppelen van klikactie aan de newProfileBackButton
        accountBackButton.setOnClickListener {
            // Teruggaan naar het vorige scherm
            finish()
        }


        btnDeleteAccount.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Delete account")
            builder.setMessage("Are you sure you want to delete your account?")

            builder.setPositiveButton("Yes!") { _, _ ->
                val username = sessionManager.getUsername()
                val password = sessionManager.getPassword()
                if (username != null && password != null) {
                    deleteUserAccount(username, password)
                } else {
                    Toast.makeText(this, "Username or password is missing.", Toast.LENGTH_SHORT).show()
                }
            }
            builder.setNegativeButton("No!") { dialog, _ ->
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }

        btnLogout.setOnClickListener {
            sessionManager.clearUserDetails() // Sessie wissen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this@AccountActivity, "You are logged out!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteUserAccount(username: String, password: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val app = application as? HireHubApplication ?: return@launch
            val userRepository = app.userRepository

            val user = withContext(Dispatchers.IO) {
                userRepository.getUserByUsernameAndPassword(username, password)
            }

            if (user != null) {
                withContext(Dispatchers.IO) {
                    userRepository.deleteUser(user)
                }
                Toast.makeText(this@AccountActivity, "Account has been deleted.", Toast.LENGTH_SHORT).show()
                sessionManager.clearUserDetails() // Sessie wissen
                val intent = Intent(this@AccountActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@AccountActivity, "Error: Can't delete account.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
