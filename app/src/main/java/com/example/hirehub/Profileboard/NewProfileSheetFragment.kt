package com.example.hirehub.Profileboard

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentNewUserSheetBinding
import com.example.hirehub.models.User
import com.example.hirehub.viewmodels.UserViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//Afhankelijk van of de gebruiker wordt bewerkt of een nieuwe gebruiker wordt toegevoegd,
// wordt de titel van het bottom sheet en de tekstvelden dienovereenkomstig ingesteld.

class NewProfileSheetFragment(var user: User?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewUserSheetBinding
    private lateinit var userViewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        // Instellingen voor de weergave op basis van het bewerken van een bestaande gebruiker of het toevoegen van een nieuwe gebruiker
        if (user != null) {
            binding.userTitle.text = "Edit User"
            val editable = Editable.Factory.getInstance()
            binding.username.text = editable.newEditable(user!!.username)
            binding.password.text = editable.newEditable(user!!.password)
        } else {
            binding.userTitle.text = "New User"
        }

        // ViewModel aanmaken voor gebruikersacties
        userViewModel = ViewModelProvider(activity).get(UserViewModel::class.java)
        binding.saveUserButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewUserSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Functie voor het opslaan van een nieuwe gebruiker of bijwerken van een bestaande gebruiker
    private fun saveAction() {
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()
        if (user == null) {
            // Nieuwe gebruiker aanmaken en toevoegen aan de database
            val newUser = User(username, password)
            userViewModel.addUser(newUser)
        } else {
            // Bestaande gebruiker bijwerken met de nieuwe gegevens
            user!!.username = username
            user!!.password = password
            userViewModel.updateUser(user!!)
        }

        // Tekstvelden legen en het bottom sheet sluiten
        binding.username.setText("")
        binding.password.setText("")
        dismiss()
    }
}
