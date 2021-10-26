package com.example.coordenadas

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coordenadas.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
            coordenadas()
        }
        fun coordenadas(){
            binding.botonbusca.setOnClickListener{
                val geocoder = Geocoder(this, Locale.getDefault())
                val addressList = geocoder.getFromLocationName("${binding.box.text.toString()}",1)
                if (addressList[0].hasLatitude() && addressList[0].hasLongitude()){
                    binding.latitudevar.setText("${addressList[0].latitude}")
                    binding.longitudevar.setText("${addressList[0].longitude}")
                }
                binding.ciudadvar.setText("${binding.box.text.toString()}")
                binding.box.setText("")
            }
        }
    }
