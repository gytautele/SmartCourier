package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val mapButton = findViewById<Button>(R.id.mapButton)
        mapButton.setOnClickListener {

            //Isimti coordinates ir nusiust i kita page
            //val x = findViewById<TextView>(R.id.coordinate) as TextView
            //Send: intent.putExtra("x", x.text.toString())

            val intent = Intent(this, Main4Activity::class.java)
            startActivity(intent)
        }
    }
}
