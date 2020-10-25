package com.ismanusiskurjeris.ismanusiskurjeris

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        Toast.makeText(applicationContext, "Cia bus mapsai", Toast.LENGTH_SHORT).show()
    }
}
