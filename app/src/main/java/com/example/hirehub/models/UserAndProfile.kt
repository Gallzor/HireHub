package com.example.hirehub.models

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndProfile(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id", // Verander dit naar de juiste kolomnaam in User die de relatie definieert
        entityColumn = "userId"
    )
    val profile: Profile
)

