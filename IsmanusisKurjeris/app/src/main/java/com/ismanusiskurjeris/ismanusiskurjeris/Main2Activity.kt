package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

            fun onCreateOptionsMenu(menu: Menu):Boolean {
                val inflater = getMenuInflater()
                inflater.inflate(R.menu.my_options_menu, menu)
                return true
            }

        //Send: intent.putExtra("Username", username.text.toString())
        //Receive: var strUser: String = intent.getStringExtra("Username")
        //Toast.makeText(applicationContext, "Puslapis veikia", Toast.LENGTH_SHORT).show()

        val searchButton = findViewById<Button>(R.id.searchButton)
        val searchButton2 = findViewById<Button>(R.id.searchButton2)
        searchButton.setOnClickListener {
            val packageId = findViewById<EditText>(R.id.packageId) as EditText
            //Siuntimui i duombaze packageId.text.toString()
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }

        val ieskoti = findViewById<Button>(R.id.ieskoti)
        val siuntos = findViewById<Button>(R.id.siuntos)
        val nustatymai = findViewById<Button>(R.id.nustatymai)
        val atsijungti = findViewById<Button>(R.id.atsijungti)
        val paskyra = findViewById<Button>(R.id.paskyra)

        ieskoti.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        siuntos.setOnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }
        nustatymai.setOnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }
        atsijungti.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        paskyra.setOnClickListener {
            val intent = Intent(this, Main4Activity::class.java)
            startActivity(intent)
        }
    }
}
