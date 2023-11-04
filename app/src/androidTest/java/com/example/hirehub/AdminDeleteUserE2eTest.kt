package com.example.hirehub

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.*

// end2end test waarbij wordt gekeken of de ongeregistreerde gebruiker kan inloggen als admin,
// om vervolgens naar de userboard te gaan, de users te bekijken en een user verwijderen.
// daarna kan de admin besluiten of hij zeker weet dat hij de gebruiker verwijdert
// en wordt terug gestuurd naar de userboard pagina.
// De test begint dus bij anoniem, en eindigt bij een een verwijderde gebruiker.
// De test is geslaagd als de getelde users afgenomen is met 1.

@RunWith(AndroidJUnit4::class)
class AdminLoginE2ETest {

    // ClickChildViewWithId-functie om de deletebutton te selecteren
    private fun clickChildViewWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): org.hamcrest.Matcher<View> {
                return isAssignableFrom(View::class.java)
            }

            override fun perform(uiController: UiController?, view: View?) {
                val childView = view?.findViewById<View>(id)
                childView?.performClick()
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }
        }
    }

    // Functie om de gebruikers in de lijst te tellen
    fun getRecyclerViewItemCount(@IdRes recyclerViewId: Int): Int {
        val itemCount = intArrayOf(0)
        onView(allOf(withId(recyclerViewId), isAssignableFrom(RecyclerView::class.java)))
            .check { view, noViewFoundException ->
                if (view is RecyclerView) {
                    itemCount[0] = view.adapter?.itemCount ?: 0
                } else {
                    throw noViewFoundException
                }
            }
        return itemCount[0]
    }


    @Before
    fun setUp() {
        // Start de MainActivity voordat elke test begint
        val scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testAdminLoginAndSession() {
        // Klik op de accountButton om naar LoginActivity te gaan
        onView(withId(R.id.accountButton))
            .perform(click())

        // Controleer of LoginActivity is geopend
        onView(withId(R.id.etUsername))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Voer gebruikersnaam en wachtwoord in
        onView(withId(R.id.etUsername))
            .perform(ViewActions.typeText("Kauwgumpje"))
        onView(withId(R.id.etPassword))
            .perform(ViewActions.typeText("Admin1234"))

        // Klik op de login-knop
        onView(withId(R.id.btnLogin))
            .perform(click())

        // Controleer of de login succesvol is geweest en dat je bent beland in de MainActivity
        onView(withId(R.id.accountButton))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Klik op de "User CRUD Button" in de MainActivity om naar UserboardActivity te gaan
        onView(withId(R.id.userCrudButton))
            .perform(click())

        // Controleer of UserboardActivity is geopend
        onView(withId(R.id.searchEditText))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Tel het oorspronkelijke aantal gebruikers in de RecyclerView om later te controleren of er 1 vanaf is gegaan.
        val initialItemCount = getRecyclerViewItemCount(R.id.UserBoardRecyclerView)

        // Klik op de "Delete User Button" in de eerste user_item_cell
        Espresso.onView(ViewMatchers.withId(R.id.UserBoardRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    clickChildViewWithId(R.id.deleteUserButton)
                )
            )

        // Wacht een korte tijd om ervoor te zorgen dat de fragment verschijnt
        Thread.sleep(1000)

        // Controleer of de Delete User Button in de fragment aanwezig is
        Espresso.onView(ViewMatchers.withId(R.id.confirmDeleteUserButton))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Klik op de "Delete User Button" in de fragment
        Espresso.onView(ViewMatchers.withId(R.id.confirmDeleteUserButton))
            .perform(ViewActions.click())

        // Tel het huidige aantal gebruikers in de RecyclerView
        val currentItemCount = getRecyclerViewItemCount(R.id.UserBoardRecyclerView)

        // Controleer of het aantal is verminderd met 1
        assertThat(
            "Aantal gebruikers is verminderd na verwijderen.",
            currentItemCount,
            `is`(initialItemCount - 1)
        )
    }
}