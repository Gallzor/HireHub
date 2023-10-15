package com.example.hirehub.clicklisteners

import com.example.hirehub.models.User

interface UserboardClickListener
{
    fun editUser(user: User)
    fun deleteUser(user: User)

}