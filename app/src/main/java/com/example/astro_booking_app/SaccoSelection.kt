package com.example.astro_booking_app

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase

class SaccoSelection : AppCompatActivity() {

    lateinit var sacco_first:TextView
    lateinit var sacco_second:TextView
    lateinit var sacco_third:TextView
    lateinit var sacco_fourth:TextView
    lateinit var sacco_fifth:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sacco_selection)

        sacco_first = findViewById(R.id.sacco1)
        sacco_second = findViewById(R.id.sacco2)
        sacco_third = findViewById(R.id.sacco3)
        sacco_fourth = findViewById(R.id.sacco4)
        sacco_fifth = findViewById(R.id.sacco5)

        sacco_first.setOnClickListener {
            var gotonorth = Intent(this,NorthRiftActivity::class.java)
            startActivity(gotonorth)
        }

        sacco_second.setOnClickListener {
            var gotoroyal = Intent(this,RoyalRiftActivity::class.java)
            startActivity(gotoroyal)
        }

        sacco_third.setOnClickListener {
            var gotoeasy = Intent(this,EasyCoachActivity::class.java)
            startActivity(gotoeasy)
        }

        sacco_fourth.setOnClickListener {
            var gotogreat = Intent(this,GreatRiftActivity::class.java)
            startActivity(gotogreat)
        }

        sacco_fifth.setOnClickListener {
            var gotoeldo = Intent(this,EldoretSaccoActivity::class.java)
            startActivity(gotoeldo)
        }


        }
    }





