package com.example.astro_booking_app

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    lateinit var log_edt_email:EditText
    lateinit var log_edt_password:EditText
    lateinit var log_btn_log:Button
    lateinit var log_txt_google:TextView
    lateinit var log_txt_signup:TextView

    //Initialise Firebase
    lateinit var auth: FirebaseAuth

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

        auth = FirebaseAuth.getInstance()

        log_btn_log.setOnClickListener {
            var email = log_edt_email.text.toString().trim()
            var password = log_edt_password.text.toString().trim()

            //Validate Input
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the inputs is empty", Toast.LENGTH_SHORT).show()
            } else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        var gotomain = Intent(this, DashboardActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    } else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

        log_txt_google.setOnClickListener {}

        log_txt_signup.setOnClickListener {
            var gotoregister = Intent(this,RegisterActivity::class.java)
            startActivity(gotoregister)
        }

    }

}