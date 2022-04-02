package com.barrybbarrios.parstagram

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.barrybbarrios.parstagram.fragments.ComposeFragment
import com.barrybbarrios.parstagram.fragments.FeedFragment
import com.barrybbarrios.parstagram.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.*
import java.io.File

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {

            item  ->

            var fragmentToShow: Fragment? = null
            when (item.itemId){
                R.id.action_home -> {
                    // TODO Navigate to the home screen
                    fragmentToShow = FeedFragment()
                }
                R.id.action_compose -> {
                    // TODO Navigate to the Compose screen
                    fragmentToShow = ComposeFragment()
                }
                R.id.action_profile -> {
                    // TODO Navigate to the Profile screen
                    fragmentToShow = ProfileFragment()
                }
            }
            if (fragmentToShow != null){
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }
            // Return true to say that we've handled this user interaction on the item
            true
        }
        // queryPosts()
        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home
    }








    companion object {
        const val TAG = "MainActivity"
    }
}