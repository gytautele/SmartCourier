package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.select.Evaluator

class Main4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var ID = 106

        val change = findViewById<Button>(R.id.mapButton3)
        change.setOnClickListener {
            val intent = Intent(this, Main5Activity::class.java)
            startActivity(intent)
        }

        val submit = findViewById<Button>(R.id.mapButton2)
        submit.setOnClickListener {
            val X = findViewById<EditText>(R.id.Xkoordinate) as EditText
            val Y = findViewById<EditText>(R.id.Ykoordinate) as EditText
            val Status = findViewById<EditText>(R.id.Statusas) as EditText
            val Details = findViewById<EditText>(R.id.Detales) as EditText

            val db = dbManager(this)

            val insert = db.insertuserdata(X.text.toString().toDouble(), Y.text.toString().toDouble(), Status.text.toString(), Details.text.toString(), ID)
            if (insert) {
                Toast.makeText(this, "Duomenys sėkmingai pridėti, naujas ID: " + ID, Toast.LENGTH_SHORT).show();
                ID = ID + 1
            }
            else {
                Toast.makeText(this, "Duomenys nebuvo pridėti", Toast.LENGTH_SHORT).show();
            }
        }

        val ieskoti = findViewById<Button>(R.id.ieskoti)
        val siuntos = findViewById<Button>(R.id.siuntos)
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