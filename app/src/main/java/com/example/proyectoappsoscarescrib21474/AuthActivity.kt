package com.example.proyectoappsoscarescrib21474

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class AuthActivity: AppCompatActivity() {
    private lateinit var btnRegistro: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnAcceder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        //------------------ llamar los elementos ----------------------------------------
        btnRegistro =findViewById(R.id.button)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnAcceder=findViewById(R.id.button6)
        //--------------------------------------------------------------------------------

        //codigo para llamar a la funcion de autenticacion de Firebase
        setup()
    }
    private fun setup() {
        title="Autenticacion"
        btnRegistro.setOnClickListener{
            if (etEmail.text.isNotEmpty() && etPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful) {
                        showHome(it.result?.user?.email ?:"", ProviderType.BASIC)
                    }else {
                        alerts()
                    }
                }
            }
        }
        btnAcceder.setOnClickListener{
            if (etEmail.text.isNotEmpty() && etPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful) {
                        showHome(it.result?.user?.email ?:"", ProviderType.BASIC)
                    }else {
                        alerts()
                    }
                }
            }
        }
    }
    private fun alerts() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("error")
        builder.setMessage("Se ha producido un error")
        builder.setPositiveButton("aceptar", null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }
    private fun showHome(email: String, provider: ProviderType){
        val intent = Intent(this, Home::class.java).apply {
            putExtra("email",email)
            putExtra("provider", provider.name)
        }
        startActivity(intent)
    }
}