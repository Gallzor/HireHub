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
    private val clickListener: UserboardClickListener,  // Click listener voor gebruikersacties
    private var filteredUsers: List<User> = users // Lijst met gefilterde gebruikers
) : RecyclerView.Adapter<UserboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserboardViewHolder {
        // Inflating van de gebruikersitem layout en aanmaken van een view holder
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemCellBinding.inflate(inflater, parent, false)
        return UserboardViewHolder(parent.context, binding, clickListener)
    }

    // Functie om de gebruikers te filteren op basis van een zoekopdracht
    fun filterUsers(query: String) {
        filteredUsers = if (query.isEmpty()) {
            users
        } else {
            users.filter { it.username.contains(query, ignoreCase = true) }
        }
        // Breng de adapter op de hoogte van de gewijzigde gegevens
        notifyDataSetChanged()
    }

    // Geeft het aantal gebruikers in de lijst terug
    override fun getItemCount(): Int = filteredUsers.size

    override fun onBindViewHolder(holder: UserboardViewHolder, position: Int) {
        // Deze functie wordt aangeroepen om de gegevens van een bepaalde gebruiker aan de view holder te binden, op basis van de positie in de lijst.
        holder.bindUser(filteredUsers[position])
    }
}