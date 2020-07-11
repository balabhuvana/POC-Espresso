package com.arunv.poc_espresso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arunv.poc_espresso.R.id.my_frame_container

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        supportFragmentManager.beginTransaction().replace(my_frame_container, RoomFragment())
            .commit()
    }
}
