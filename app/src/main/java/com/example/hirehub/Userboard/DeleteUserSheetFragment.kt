package com.example.hirehub.Userboard

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hirehub.databinding.FragmentDeleteUserSheetBinding
import com.example.hirehub.models.User
import com.example.hirehub.viewmodels.UserViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//Afhankelijk van of de gebruiker wordt bewerkt of een nieuwe gebruiker wordt toegevoegd,
// wordt de titel van het bottom sheet en de tekstvelden dienovereenkomstig ingesteld.

class DeleteUserSheetFragment(var user: User?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDeleteUserSheetBinding
    private lateinit var userViewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        binding.confirmDeleteUserButton.setOnClickListener {
            confirmDeleteAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDeleteUserSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun confirmDeleteAction() {
        // Haal de gebruiker op uit de ViewModel en gebruik de juiste functie om deze te verwijderen.
        userViewModel.deleteUser(user!!)

        // Sluit het bottom sheet nadat de gebruiker is verwijderd
        dismiss()
    }
}