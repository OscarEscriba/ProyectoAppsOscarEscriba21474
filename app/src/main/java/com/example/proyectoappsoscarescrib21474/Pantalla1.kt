package com.example.proyectoappsoscarescrib21474

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.proyectoappsoscarescrib21474.databinding.ActivityPantalla1Binding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Pantalla1 : AppCompatActivity() {
    private lateinit var binding: ActivityPantalla1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantalla1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        //los eventos onclik para ir cambiando   entre cada una de las siguientes partes del menu...
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.Home -> replaceFragment(Home())
                R.id.calculadora ->replaceFragment(calculadora())
                R.id.mas -> replaceFragment(mas())
                else -> {
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}