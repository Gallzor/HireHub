package com.example.hirehub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hirehub.clicklisteners.UserboardClickListener
import com.example.hirehub.databinding.UserItemCellBinding
import com.example.hirehub.models.User
import com.example.hirehub.viewholders.UserboardViewHolder

class UserboardAdapter(
    private val users: List<User>,  // Lijst met gebruikers die aan de adapter wordt doorgegeven
    private val clickListener: UserboardClickListener  // Click listener voor gebruikersacties

) : RecyclerView.Adapter<UserboardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserboardViewHolder {
        // Inflating van de gebruikersitem layout en aanmaken van een view holder
        val from = LayoutInflater.from(parent.context)
        val binding = UserItemCellBinding.inflate(from, parent, false)
        return UserboardViewHolder(parent.context, binding, clickListener)
    }

    override fun getItemCount(): Int = users.size  // Geeft het aantal gebruikers in de lijst terug

    override fun onBindViewHolder(holder: UserboardViewHolder, position: Int) {
        // Deze functie wordt aangeroepen om de gegevens van een bepaalde gebruiker aan de view holder te binden, op basis van de positie in de lijst.
        holder.bindUser(users[position])
    }
}
