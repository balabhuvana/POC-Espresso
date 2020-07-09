package com.arunv.poc_espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest {
    @Test
    fun testHomeFragmentUI() {

        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.tvUsername))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etPassword))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnStartFirstFragment))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationFlowToFirstFragment() {

        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.btnStartFirstFragment)).perform(click())

        onView(withId(R.id.tvFirstFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationFlowOfAllTheFragment() {

        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.btnStartFirstFragment)).perform(click())

        onView(withId(R.id.tvFirstFragment)).check(matches(isDisplayed()))

        pressBack()

        onView(withId(R.id.my_home_fragment_root_container))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnStartSecondFragment)).perform(click())

        onView(withId(R.id.tvSecondFragment)).check(matches(isDisplayed()))

    }

}
