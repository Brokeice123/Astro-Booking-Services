package com.example.astro_booking_app


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {

    private lateinit var mbtnstart:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        // hide status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcomeactivity)

        mbtnstart = findViewById(R.id.btn_start)

        mbtnstart.setOnClickListener {
            var gotoregister = Intent(this, RegisterActivity::class.java)
            startActivity(gotoregister)
        }

    }

    override fun onStart() {
        super.onStart()
        if(FirebaseAuth.getInstance().currentUser != null){
            val i  = Intent(this,BookingActivity::class.java)
            startActivity(i)
        }
    }

}