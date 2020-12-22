package com.ismanusiskurjeris.ismanusiskurjeris

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Main5Activity : AppCompatActivity() {

    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "1234"
    private val description = "Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val change = findViewById<Button>(R.id.mapButton3)
        change.setOnClickListener {

            val ID = findViewById<EditText>(R.id.SiuntosID) as EditText
            val Statusas = findViewById<EditText>(R.id.status) as EditText

            val db = dbManager(this)

            val update = db.updateuserdata(ID.text.toString(), Statusas.text.toString())
            if (update) {
                Toast.makeText(this, "Duomenys sėkmingai atnaujanti", Toast.LENGTH_SHORT).show()

                btnNotify(Statusas.text.toString())

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

    fun btnNotify(String: String) {
        val intent = Intent(this, Main2Activity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        val contentView = RemoteViews(packageName, R.layout.notification_layout)
        contentView.setTextViewText(R.id.tv_title,"Ikurjeris")
        contentView.setTextViewText(R.id.tv_content,"Statuas sėkmingai atnaujinti į " + String)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this,channelId)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.logo)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.logo))
                    .setContentIntent(pendingIntent)
        }else{

            builder = Notification.Builder(this)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.logo)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.logo))
                    .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234,builder.build())
    }

}