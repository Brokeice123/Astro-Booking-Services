package com.example.astro_booking_app

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    lateinit var log_edt_email:EditText
    lateinit var log_edt_password:EditText
    lateinit var log_btn_log:Button
    lateinit var log_txt_google:TextView
    lateinit var log_txt_signup:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        // hide status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)

        log_edt_email = findViewById(R.id.edtLogemail)
        log_edt_password = findViewById(R.id.edtLogpassword)
        log_btn_log = findViewById(R.id.btnLoglog)
        log_txt_google = findViewById(R.id.txtLogGoogle)
        log_txt_signup = findViewById(R.id.txtLogsignup)

    }

}