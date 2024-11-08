package com.hamza.mysimpleadapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listview = findViewById<ListView>(R.id.listview)

        val produit = listOf(
            mapOf("name" to "produit1", "price" to "10Dh"),
            mapOf("name" to "produit2", "price" to "15Dh"),
            mapOf("name" to "produit3", "price" to "20Dh"),
            mapOf("name" to "produit4", "price" to "25Dh")
        )

        listview.adapter = SimpleAdapter(
            this,
            produit,
            R.layout.profile,
            arrayOf("name", "price"),
            intArrayOf(R.id.text1, R.id.text2)
        )
    }
}