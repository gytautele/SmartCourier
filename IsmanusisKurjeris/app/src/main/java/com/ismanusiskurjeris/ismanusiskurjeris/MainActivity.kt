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
            val checkinsertdata: Boolean = db.insertuserdata(username.text.toString(), password.text.toString(), "LABAS")
            if (checkinsertdata == true) Toast.makeText(this@MainActivity, "New Entry Inserted", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this@MainActivity, "New Entry Not Inserted", Toast.LENGTH_SHORT).show()

            val res = db.getdata();
            if(res.getCount()==0){
                Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            }
            val buffer = StringBuffer();
            while(res.moveToNext()){
                buffer.append("Name :"+res.getString(0)+"\n");
                buffer.append("Contact :"+res.getString(1)+"\n");
                buffer.append("Date of Birth :"+res.getString(2)+"\n\n");
            }

            val builder = AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("User Entries");
            builder.setMessage(buffer.toString());
            builder.show()


            //Toast.makeText(this, db.addUser(username.text.toString(), password.text.toString()), Toast.LENGTH_LONG).show()

            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}
