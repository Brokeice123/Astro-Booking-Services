package com.example.astro_booking_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class TicketActivity : AppCompatActivity() {

    lateinit var details:TextView
    lateinit var phone:TextView
    lateinit var ID:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ticket_activity)

        details = findViewById(R.id.txt_details)
        phone = findViewById(R.id.txt_phone)
        ID = findViewById(R.id.txt_id)

        var detailstextview = intent.getStringExtra("destination")
        details.setText(detailstextview)

        var phonetextview = intent.getStringExtra("phone")
        phone.setText(phonetextview)

        var idtextview = intent.getStringExtra("time_id")
        ID.setText(idtextview)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

    }
}