package com.example.proyectoappsoscarescrib21474
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.proyectoappsoscarescrib21474.databinding.Pantalla1Binding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Pantalla1: AppCompatActivity() {
    private lateinit var binding: Pantalla1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Pantalla1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //los eventos onclik para ir cambiando   entre cada una de las siguientes partes del menu...
        binding.bottomNavigationView.setOnItemSelectedListener {

        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}

