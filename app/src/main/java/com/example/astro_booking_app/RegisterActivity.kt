package com.example.astro_booking_app

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var m_edt_name:EditText
    lateinit var m_edt_email:EditText
    lateinit var m_edt_phone:EditText
    lateinit var m_edt_password:EditText
    lateinit var m_edt_password2:EditText
    lateinit var m_btn_create:Button
    lateinit var m_txt_signin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        // hide status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.registeractivity)

        m_edt_name = findViewById(R.id.edtRegname)
        m_edt_email = findViewById(R.id.edtRegemail)
        m_edt_phone = findViewById(R.id.edtRegphone)
        m_edt_password = findViewById(R.id.edtRegpassword)
        m_edt_password2 = findViewById(R.id.edtRegpassword2)
        m_btn_create = findViewById(R.id.btnRegcreate)
        m_txt_signin = findViewById(R.id.txtRegsignin)



    }


}