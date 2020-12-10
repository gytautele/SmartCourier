package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
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
//            val checkinsertdata: Boolean = db.insertuserdata(username.text.toString(), password.text.toString(), "LABAS")
//            if (checkinsertdata == true) Toast.makeText(this@MainActivity, "New Entry Inserted", Toast.LENGTH_SHORT).show()
//            else Toast.makeText(this@MainActivity, "New Entry Not Inserted", Toast.LENGTH_SHORT).show()

            val login = db.LogIn(username.text.toString(), password.text.toString())
            if (login) {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Sveiki prisijunge: " + username.text.toString(), Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Tokio vartotojo nera", Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(this, db.addUser(username.text.toString(), password.text.toString()), Toast.LENGTH_LONG).show()
        }
    }
}
