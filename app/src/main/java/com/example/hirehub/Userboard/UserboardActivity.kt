package com.example.hirehub.Userboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hirehub.adapters.UserboardAdapter
import com.example.hirehub.clicklisteners.UserboardClickListener
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityUserboardBinding
import com.example.hirehub.factories.ProfileModelFactory
import com.example.hirehub.factories.UserModelFactory
import com.example.hirehub.models.User
import com.example.hirehub.viewmodels.UserViewModel

class UserboardActivity : AppCompatActivity(), UserboardClickListener
{
    // Binding voor de activity layout
    private lateinit var binding: ActivityUserboardBinding

    // ViewModel instantie verkrijgen met behulp van de ViewModelProvider en UserModelFactory
    // Het wordt geïnstantieerd op een luie manier, wat betekent dat het alleen wordt aangemaakt wanneer het nodig is
    private val userViewModel: UserViewModel by viewModels {
        UserModelFactory((application as HireHubApplication).userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflating (opblazen) van de activity layout en deze instellen als de content view
        binding = ActivityUserboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Een click listener instellen voor de knop die wordt gebruikt om een nieuwe gebruiker toe te voegen
        binding.newUserButton.setOnClickListener {
            NewUserSheetFragment(null).show(supportFragmentManager, "newUserTag")
        }

        // Koppelen van klikactie aan de newProfileBackButton
        binding.newUserBackButton.setOnClickListener {
            // Teruggaan naar het vorige scherm
            finish()
        }

        // De recyclerview instellen voor het weergeven van gebruikers
        setRecyclerView()

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                (binding.UserBoardRecyclerView.adapter as UserboardAdapter).filterUsers(query)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

        // Functie om de recyclerview in te stellen
    private fun setRecyclerView()
    {
        val UserboardActivity = this
        // Observeren van de gebruikerslijst in de ViewModel en het bijwerken van de RecyclerView-adapter wanneer er veranderingen zijn
        userViewModel.users.observe(this){
            binding.UserBoardRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = UserboardAdapter(it, UserboardActivity)
            }
        }
    }

    // Functie die wordt aangeroepen wanneer een gebruiker wil worden bewerkt
    override fun editUser(user: User)
    {
        // Een nieuw gebruikersvenster weergeven voor het bewerken van de gebruiker
        NewUserSheetFragment(user).show(supportFragmentManager, "newUserTag")
    }

    // Een nieuw gebruikersvenster weergeven voor het verwijderen van de gebruiker
    override fun deleteUser(user: User) {
        DeleteUserSheetFragment(user).show(supportFragmentManager, "deleteUserTag")
    }
}
