package com.example.astro_booking_app


import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var mbtnstart:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        // hide status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcomeactivity)

        mbtnstart = findViewById(R.id.btn_start)

        mbtnstart.setOnClickListener {
            var gotoregister = Intent(this, RegisterActivity::class.java)
            startActivity(gotoregister)
        }

    }

}