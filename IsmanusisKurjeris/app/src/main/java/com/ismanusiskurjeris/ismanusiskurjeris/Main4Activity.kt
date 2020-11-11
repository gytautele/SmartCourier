package com.ismanusiskurjeris.ismanusiskurjeris

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

//        import android.Manifest
//                import android.content.pm.PackageManager
//                import android.location.Location
//                import android.os.Bundle
//                import android.widget.Toast
//                import androidx.core.app.ActivityCompat
//                import androidx.fragment.app.FragmentActivity
//                import com.google.android.gms.location.FusedLocationProviderClient
//                import com.google.android.gms.location.LocationServices
//                import com.google.android.gms.maps.CameraUpdateFactory
//                import com.google.android.gms.maps.GoogleMap
//                import com.google.android.gms.maps.OnMapReadyCallback
//                import com.google.android.gms.maps.SupportMapFragment
//                import com.google.android.gms.maps.model.LatLng
//                import com.google.android.gms.maps.model.MarkerOptions
//        class MainActivity : FragmentActivity(), OnMapReadyCallback {
//            private lateinit var currentLocation: Location
//            private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
//            private val permissionCode = 101
//            override fun onCreate(savedInstanceState: Bundle?) {
//                super.onCreate(savedInstanceState)
//                setContentView(R.layout.activity_main)
//                fusedLocationProviderClient =       LocationServices.getFusedLocationProviderClient(this@MainActivity)
//                fetchLocation()
//            }
//            private fun fetchLocation() {
//                if (ActivityCompat.checkSelfPermission(
//                        this, Manifest.permission.ACCESS_FINE_LOCATION) !=
//                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                        this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
//                    PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this,
//                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), permissionCode)
//                    return
//                }
//                val task = fusedLocationProviderClient.lastLocation
//                task.addOnSuccessListener { location ->
//                    if (location != null) {
//                        currentLocation = location
//                        Toast.makeText(applicationContext, currentLocation.latitude.toString() + "" +
//                                currentLocation.longitude, Toast.LENGTH_SHORT).show()
//                        val supportMapFragment = (supportFragmentManager.findFragmentById(R.id.myMap) as
//                                SupportMapFragment?)!!
//                        supportMapFragment.getMapAsync(this@MainActivity)
//                    }
//                }
//            }
//            override fun onMapReady(googleMap: GoogleMap?) {
//                val latLng = LatLng(currentLocation.latitude, currentLocation.longitude)
//                val markerOptions = MarkerOptions().position(latLng).title("I am here!")
//                googleMap?.animateCamera(CameraUpdateFactory.newLatLng(latLng))
//                googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5f))
//                googleMap?.addMarker(markerOptions)
//            }
//            override fun onRequestPermissionsResult(requestCode: Int, permissions:    Array<String?>,
//                                                    grantResults: IntArray) {
//                when (requestCode) {
//                    permissionCode -> if (grantResults.isNotEmpty() && grantResults[0] ==
//                        PackageManager.PERMISSION_GRANTED) {
//                        fetchLocation()
//                    }
//                }
//            }
//        }



        Toast.makeText(applicationContext, "Cia bus mapsai", Toast.LENGTH_SHORT).show()

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
            val intent = Intent(this, Main4Activity::class.java)
            startActivity(intent)
        }
    }
}
