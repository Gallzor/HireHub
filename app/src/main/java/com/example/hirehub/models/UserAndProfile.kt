package com.example.hirehub.models

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndProfile(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val profile: Profile
)

