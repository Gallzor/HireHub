package com.example.hirehub.Userboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hirehub.adapters.UserboardAdapter
import com.example.hirehub.clicklisteners.UserboardClickListener
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityUserboardBinding
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
        UserModelFactory((application as HireHubApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflating (opblazen) van de activity layout en deze instellen als de content view
        binding = ActivityUserboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Een click listener instellen voor de knop die wordt gebruikt om een nieuwe gebruiker toe te voegen
        binding.newUserButton.setOnClickListener{
            NewUserSheetFragment(null).show(supportFragmentManager, "newUserTag")
        }
        // De recyclerview instellen voor het weergeven van gebruikers
        setRecyclerView()
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
}
