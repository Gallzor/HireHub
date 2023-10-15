package com.example.hirehub.clicklisteners

import com.example.hirehub.models.Profile

interface ProfileboardClickListener
{
    fun editProfile(profile: Profile)
    fun deleteProfile(profile: Profile)
    fun toggleVisibility(profile: Profile)
}