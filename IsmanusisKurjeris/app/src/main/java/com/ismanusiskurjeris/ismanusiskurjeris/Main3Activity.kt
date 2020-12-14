package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val packageID = intent.getStringExtra("packageID")
        val db = dbManager(this)
        val res = db.getdata(packageID)
        var clientID = ""
        var siuntinioX = ""
        var siuntinioY = ""
        var klientoX = ""
        var klientoY = ""

        if(res.getCount() == 0){
            Toast.makeText(this, "Siunta neegzistuoja", Toast.LENGTH_SHORT).show()
        }
        val buffer = StringBuffer();
        while(res.moveToNext()){
            buffer.append("Siuntinio X koordinate: "+res.getString(0)+"\n")
            buffer.append("Siuntinio Y koordinate: "+res.getString(1)+"\n")
            siuntinioX = res.getString(0)
            siuntinioY = res.getString(1)
            clientID = res.getString(2)
        }
        val res1 = db.getdata1(clientID)
        if (res1.getCount() == 0){
            Toast.makeText(this, "Siunta neturi siuntejo", Toast.LENGTH_SHORT).show();
        }
        while(res1.moveToNext()){
            buffer.append("Gavejo vardas: "+res1.getString(0)+"\n")
            buffer.append("Gavejo pavarde: "+res1.getString(1)+"\n")
            buffer.append("Gavejo numeris: "+res1.getString(2)+"\n")
            buffer.append("Gavejo X koordinate: "+res1.getString(3)+"\n")
            buffer.append("GavejoY koordinate: "+res1.getString(4)+"\n")
            klientoX = res1.getString(3)
            klientoY = res1.getString(4)
        }

        val builder = AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Siuntos informacija");
        builder.setMessage(buffer.toString());
        builder.show()

        val mapButton = findViewById<Button>(R.id.mapButton)
        mapButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("siuntiniox", siuntinioX)
            intent.putExtra("siuntinioy", siuntinioY)
            intent.putExtra("klientox", klientoX)
            intent.putExtra("klientoy", klientoY)
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
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}
