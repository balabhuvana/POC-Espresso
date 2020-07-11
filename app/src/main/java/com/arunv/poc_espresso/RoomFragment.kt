package com.arunv.poc_espresso


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import room.User
import room.UserDao
import room.UserRoomDatabase

/**
 * A simple [Fragment] subclass.
 */
class RoomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userRoomDatabase: UserRoomDatabase = UserRoomDatabase.getDatabase(this.context!!);
        val userDao: UserDao = userRoomDatabase.userDao()

        btnInsert.setOnClickListener {
            GlobalScope.launch {
                val user = User()
                user.userName = "10001"
                user.password = "abcde"
                userDao.insertUser(user)
            }
        }

        btnSelect.setOnClickListener {
            GlobalScope.launch {
                val user = userDao.getUserRecord(10001)
                activity!!.runOnUiThread {
                    tvTestDBData.text = user.password
                }
            }
        }
    }
}
