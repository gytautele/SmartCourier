package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Main5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val change = findViewById<Button>(R.id.mapButton3)
        change.setOnClickListener {

            val ID = findViewById<EditText>(R.id.SiuntosID) as EditText
            val Statusas = findViewById<EditText>(R.id.status) as EditText

            val db = dbManager(this)

            val update = db.updateuserdata(ID.text.toString(), Statusas.text.toString())
            if (update) {
                Toast.makeText(this, "Duomenys sėkmingai atnaujanti", Toast.LENGTH_SHORT).show()
                var builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.logo)
                    .setContentTitle("My notification")
                    .setContentText("Much longer text that cannot fit one line...")
                    .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                with(NotificationManagerCompat.from(this)) {
                    // notificationId is a unique int for each notification that you must define
                    notify(notificationId, builder.build())
                }
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Duomenys nebuvo atnaujinti", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
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