package com.arunv.poc_espresso


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnStartFirstFragment.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.my_frame_container, FirstFragment())
                .addToBackStack(null)
                .commit()
        }

        btnStartSecondFragment.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.my_frame_container, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}
