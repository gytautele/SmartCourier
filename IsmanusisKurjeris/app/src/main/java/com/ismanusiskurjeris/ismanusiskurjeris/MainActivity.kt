package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logInButton = findViewById<Button>(R.id.logInButton)
        logInButton.setOnClickListener{

            val username = findViewById<EditText>(R.id.username) as EditText
            val password = findViewById<EditText>(R.id.password) as EditText
            val labas = 5

            val db = dbManager(this)

            val login = db.LogIn(username.text.toString(), password.text.toString())
            if (login) {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Sveiki prisijunge: " + username.text.toString(), Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Tokio vartotojo nera", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
