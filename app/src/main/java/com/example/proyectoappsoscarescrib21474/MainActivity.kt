package com.example.proyectoappsoscarescrib21474

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //codigo para darle funcionalidad al boton...
        val Pantalla: Button = findViewById(R.id.button)
        Pantalla.setOnClickListener{
            openActivityPantalla()
        }
    }
    private fun openActivityPantalla() {
        //crear la intencion para abrir Activity
        val intent = Intent(this, Pantalla1::class.java)
        //iniciar la actividad
        startActivity(intent)
    }
}