package com.arunv.poc_espresso

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import room.User
import room.UserDao
import room.UserRoomDatabase
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class RoomFragmentTest {

    private lateinit var userDao: UserDao
    private lateinit var userRoomDatabase: UserRoomDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        userRoomDatabase = Room.inMemoryDatabaseBuilder(
            context, UserRoomDatabase::class.java
        ).build()
        userDao = userRoomDatabase.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        userRoomDatabase.close()
    }

    @Test
    fun testRoomFragmentUIWithRoom() {

        ActivityScenario.launch(RoomActivity::class.java)

        onView(ViewMatchers.withId(R.id.tvTestDBData))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withId(R.id.btnInsert))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withId(R.id.btnSelect))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val user = User()
        user.userName = "10001"
        user.password = "abdcef"
        userDao.insertUser(user)

        Thread.sleep(2000)

        onView(ViewMatchers.withId(R.id.btnInsert))
            .perform(click())

        onView(ViewMatchers.withId(R.id.btnSelect))
            .perform(click())

        Thread.sleep(2000)

        onView(ViewMatchers.withText(user.password));

    }

}