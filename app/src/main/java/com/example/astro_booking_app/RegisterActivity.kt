package com.example.astro_booking_app

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    lateinit var m_edt_name:EditText
    lateinit var m_edt_email:EditText
    lateinit var m_edt_phone:EditText
    lateinit var m_edt_password:EditText
    lateinit var m_edt_password2:EditText
    lateinit var m_btn_create:Button
    lateinit var m_txt_signin:TextView

    lateinit var auth: FirebaseAuth

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

        auth = FirebaseAuth.getInstance()
        //Create Account
        m_btn_create.setOnClickListener {
            var name = m_edt_name.text.toString().trim()
            var email = m_edt_email.text.toString().trim()
            var phone = m_edt_phone.text.toString().trim()
            var password = m_edt_password.text.toString().trim()
            var password2 = m_edt_password2.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                Toast.makeText(this, "Cannot submit empty fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {
                if (password == password2) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                        if (it.isSuccessful){
                            Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                            var gotologin = Intent(this, LoginActivity::class.java)
                            startActivity(gotologin)
                        } else{
                            Toast.makeText(this, "Failed to Create Account", Toast.LENGTH_SHORT).show()
                        }
                }
            }else {
                    Toast.makeText(this, "Incorrect passwords used. Kindly check your passwords", Toast.LENGTH_SHORT).show()
                }
            }

        }

        m_txt_signin.setOnClickListener {
            var gotologin = Intent(this,LoginActivity::class.java)
            startActivity(gotologin)
        }



    }


}