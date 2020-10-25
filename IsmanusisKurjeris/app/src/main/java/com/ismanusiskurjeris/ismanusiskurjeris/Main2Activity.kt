package com.ismanusiskurjeris.ismanusiskurjeris

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Send: intent.putExtra("Username", username.text.toString())
        //Receive: var strUser: String = intent.getStringExtra("Username")
        //Toast.makeText(applicationContext, "Puslapis veikia", Toast.LENGTH_SHORT).show()

        val searchButton = findViewById<Button>(R.id.searchButton)
        searchButton.setOnClickListener {

            val packageId = findViewById<EditText>(R.id.packageId) as EditText
        }


    }
}
