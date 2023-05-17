package com.example.astro_booking_app

import android.content.ClipData
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import android.graphics.Color
import android.os.Build
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class BookingActivity : AppCompatActivity() {

    lateinit var listView:ListView
    lateinit var list: ArrayList<String>
    lateinit var adapter: ArrayAdapter<*>
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booking_activity)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }


        searchView = findViewById(R.id.searchView)
        listView = findViewById(R.id.mylistview)

        list = ArrayList()
        list.add("NAIROBI-ELDORET, SH1200")
        list.add("ELDORET-NAIROBI, SH1200")
        list.add("NAIROBI-KISUMU, SH1650")
        list.add("KISUMU-NAIROBI, SH1650")
        list.add("NAIROBI-MOMBASA, SH2000")
        list.add("MOMBASA-NAIROBI, SH2000")
        list.add("NAIROBI-NAKURU, SH800")
        list.add("NAKURU-NAIROBI, SH800")
        list.add("NAIROBI-KITALE, SH1500")
        list.add("KITALE-NAIROBI, SH1500")
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list.contains(query)) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(this@BookingActivity, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        //Changing color of Search Hint
        val colorString = "#A5A6A8"
        val color = Color.parseColor(colorString)
        val hint = SpannableStringBuilder("Search")
        hint.setSpan(ForegroundColorSpan(color), 0, hint.length, 0)
        searchView.queryHint = hint

        //Navigating user choice to take to DetailActivity
        val dataList: ArrayList<String> = list // Your ArrayList containing the data

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", selectedItem)
            startActivity(intent)
        }

    }

}
