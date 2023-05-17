package com.example.astro_booking_app

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class DetailActivity : AppCompatActivity() {

    lateinit var title_disp: TextView
    lateinit var tick_btn: Button
    lateinit var back_btn: Button
    private lateinit var progressBar: ProgressBar
    lateinit var phone_edt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        title_disp = findViewById(R.id.txt_title_disp)
        tick_btn = findViewById(R.id.Btn_pay)
        back_btn = findViewById(R.id.Btn_back)
        phone_edt = findViewById(R.id.edtBookphone)

        val bundle = intent.extras
        val data = bundle?.getString("data")

        //taking data from the other page
        var datatextview = intent.getStringExtra("title")
        //display data into Textview
        title_disp.setText(datatextview)


            tick_btn.setOnClickListener {

                var destination = title_disp.text.toString().trim()
                var phone = phone_edt.text.toString().trim()
                var time_id = System.currentTimeMillis().toString()

                //progressbar
                var progress = ProgressDialog(this)
                progress.setTitle("Saving Ticket Information.....")
                progress.setMessage("Please Wait")
                //Validation
                if (phone.isEmpty()) {
                    Toast.makeText(this, "Cannot Submit Empty Phone Field", Toast.LENGTH_SHORT).show()
                } else {
                    var my_child = FirebaseDatabase.getInstance().reference.child("Ticket/"+time_id)
                    var travel_data = Travel(destination,phone, time_id)

                    //Show progress
                    progress.show()

                    my_child.setValue(travel_data).addOnCompleteListener { 
                        
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Ticket Information Saved Successfully", Toast.LENGTH_SHORT).show()
                            //navigate to ticket view
                            var intent = Intent(this,TicketActivity::class.java)
                            intent.putExtra("destination", destination)
                            intent.putExtra("phone", phone)
                            intent.putExtra("time_id", time_id)
                            startActivity(intent)
                        }else {
                            Toast.makeText(this, "Failed to Save Ticket Information", Toast.LENGTH_SHORT).show()
                        }
                        
                    }
                    
                }
                
            }

            back_btn.setOnClickListener {
                var gotobooking = Intent(this, BookingActivity::class.java)
                startActivity(gotobooking)
            }


        }
    }
