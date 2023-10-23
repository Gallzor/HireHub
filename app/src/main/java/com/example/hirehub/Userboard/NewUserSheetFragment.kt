package com.example.hirehub.Userboard

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentNewUserSheetBinding
import com.example.hirehub.models.User
import com.example.hirehub.viewmodels.UserViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//Afhankelijk van of de gebruiker wordt bewerkt of een nieuwe gebruiker wordt toegevoegd,
// wordt de titel van het bottom sheet en de tekstvelden dienovereenkomstig ingesteld.

class NewUserSheetFragment(var user: User?) : BottomSheetDialogFragment() {

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
            binding.userRole.text = editable.newEditable(user!!.userRole)
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
        val userRole = binding.userRole.text.toString()

        // Voer validatie uit
        if (username.isEmpty() || username.length > 15) {
            // Toon een foutmelding voor 'username'
            binding.username.error = "Please fill in a correct username. Limit of 15 characters"
            return
        }

        // Voer validatie uit
        if (password.isEmpty() || password.length > 30) {
            // Toon een foutmelding voor 'password'
            binding.password.error = "Please fill in a correct password. Limit of 30 characters"
            return
        }

        // Voer validatie uit voor userRole
        if (userRole.isEmpty() || userRole.length > 3 || !isValidUserRole(userRole)) {
            // Toon een foutmelding voor 'userRole'
            binding.userRole.error = "Please fill in one of the roles. Limit of 3 characters. Choose SOL, REC, or AD"
            return
        }

        if (user == null) {
            // Nieuwe gebruiker aanmaken en toevoegen aan de database
            val newUser = User(username, password, userRole)
            userViewModel.addUser(newUser)

            // Toon een succesbericht met een Toast
            showToast("The user has been created!")

        } else {
            // Bestaande gebruiker bijwerken met de nieuwe gegevens
            user!!.username = username
            user!!.password = password
            user!!.userRole = userRole
            userViewModel.updateUser(user!!)

            // Toon een succesbericht met een Toast
            showToast("User edit has been saved!")
        }

        // Tekstvelden legen en het bottom sheet sluiten
        binding.username.setText("")
        binding.password.setText("")
        binding.userRole.setText("")
        dismiss()
    }
    // Functie om te controleren of de ingevoerde userRole geldig is
    private fun isValidUserRole(userRole: String): Boolean {
        val validRoles = setOf("SOL", "REC", "AD")
        return userRole.toUpperCase() in validRoles
    }
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
