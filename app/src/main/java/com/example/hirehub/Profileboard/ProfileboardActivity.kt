package com.example.hirehub.Profileboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hirehub.adapters.ProfileboardAdapter
import com.example.hirehub.clicklisteners.ProfileboardClickListener
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.ActivityProfileboardBinding
import com.example.hirehub.factories.ProfileModelFactory
import com.example.hirehub.models.Profile
import com.example.hirehub.viewmodels.ProfileViewModel

class ProfileboardActivity : AppCompatActivity(), ProfileboardClickListener
{
    // Binding voor de activity layout
    private lateinit var binding: ActivityProfileboardBinding

    // ViewModel instantie verkrijgen met behulp van de ViewModelProvider en ProfileModelFactory
    // Het wordt geïnstantieerd op een luie manier, wat betekent dat het alleen wordt aangemaakt wanneer het nodig is
    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileModelFactory((application as HireHubApplication).profileRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflating (opblazen) van de activity layout en deze instellen als de content view
        binding = ActivityProfileboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Een click listener instellen voor de knop die wordt gebruikt om een nieuw profiel toe te voegen
        binding.newProfileButton.setOnClickListener {
            NewProfileSheetFragment(null).show(supportFragmentManager, "newProfileTag")
        }

        // De recyclerview instellen voor het weergeven van profielen
        setRecyclerView()

        binding.searchEditTextProfile.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                (binding.ProfileBoardRecyclerView.adapter as ProfileboardAdapter).filterProfiles(query)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // Functie om de recyclerview in te stellen
    private fun setRecyclerView()
    {
        val ProfileboardActivity = this
        // Observeren van de profielenlijst in de ViewModel en het bijwerken van de RecyclerView-adapter wanneer er veranderingen zijn
        profileViewModel.profiles.observe(this){
            binding.ProfileBoardRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = ProfileboardAdapter(it, ProfileboardActivity)
            }
        }
    }

    // Functie die wordt aangeroepen wanneer een profiel wil worden bewerkt
    override fun editProfile(profile: Profile)
    {
        // Een nieuw gebruikersvenster weergeven voor het bewerken van de gebruiker
        NewProfileSheetFragment(profile).show(supportFragmentManager, "newProfileTag")
    }

    // Een nieuw profielvenster weergeven voor het verwijderen van dep rofiel
    override fun deleteProfile(profile: Profile) {
        DeleteProfileSheetFragment(profile).show(supportFragmentManager, "deleteProfileTag")
    }
}
