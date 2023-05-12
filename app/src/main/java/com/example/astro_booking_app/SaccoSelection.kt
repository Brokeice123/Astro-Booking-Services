package com.example.astro_booking_app

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SaccoSelection : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        // hide status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sacco_selection)

        val saccos = arrayListOf(
            Saccos("North Rift"),
            Saccos("Royal Rift"),
            Saccos("Great Rift"),
            Saccos("Easy Coach"),
            Saccos("Modern Coast")
        )

        recyclerView = findViewById(R.id.myRecyclerView)

        recyclerView.apply {
            layoutManager= LinearLayoutManager(this@SaccoSelection)
            adapter = SaccoAdapter(saccos)
        }

    }


}