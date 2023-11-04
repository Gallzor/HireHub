package com.example.hirehub

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

// Bij de UI-Test wordt er gekeken of een gebruiker op de profielen lijst die op de landingspagina
// de profiel gegevens van iedere individuele gebruiker kan bekijken door er op te klikken
// De test is geslaagd als de standaard titels van de profiel van de gebruiker aanwezig zijn.
@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @Before
    fun setUp() {
        // Start de MainActivity voordat elke test begint
        val scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testMainActivityUI() {
        // Controleer of de tekst "Profiles at Your Fingertips, Thanks to Hirehub" wordt weergegeven
        Espresso.onView(ViewMatchers.withText("Profiles at Your Fingertips, Thanks to Hirehub"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Klik op de eerste weergave in de profielenlijst (RecyclerView) met de specifieke ID (0: De eerste)
        Espresso.onView(withId(R.id.mainProfileListRecyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        // Controleer of de vaste titels van een profiel worden gegeven, om te kijken of de profiel word getoond.
        Espresso.onView(ViewMatchers.withText("Resume Details"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("First name"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Last name"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("City"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Age"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Mobile number"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Certificate"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Email"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Skill"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Sluit het ProfileListViewSheetFragment door ergens op te klikken
        Espresso.pressBack()
    }
}
