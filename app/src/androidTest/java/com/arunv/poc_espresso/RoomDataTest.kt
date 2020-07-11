package com.arunv.poc_espresso

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import room.User
import room.UserDao
import room.UserRoomDatabase
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class RoomDataTest {

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
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val user: User = User()
        user.userName = "10001"
        user.password = "abdcef"
        userDao.insertUser(user)
        val selectUser = userDao.getUserRecord(10001)
        assertThat(selectUser.userName, equalTo(user.userName))
        assertThat(selectUser.password, equalTo(user.password))
    }

}