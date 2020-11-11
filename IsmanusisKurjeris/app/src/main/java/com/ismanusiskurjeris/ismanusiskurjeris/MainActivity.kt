package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logInButton = findViewById<Button>(R.id.logInButton)
        logInButton.setOnClickListener{

            val username = findViewById<EditText>(R.id.packageId) as EditText
            val password = findViewById<EditText>(R.id.password) as EditText
            //Siuntimui i duombaze username.text.toString()
            //Siuntimui i duombaze password.text.toString()

            val db = dbManager(this)
            Toast.makeText(this, db.addUser(username.text.toString(), password.text.toString()), Toast.LENGTH_LONG).show()

            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}
