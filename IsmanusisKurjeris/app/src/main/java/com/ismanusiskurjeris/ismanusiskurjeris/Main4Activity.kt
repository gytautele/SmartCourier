package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Main4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

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