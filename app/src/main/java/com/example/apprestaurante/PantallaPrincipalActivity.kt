package com.example.apprestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class PantallaPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val btnAcceder = findViewById<Button>(R.id.btnAcceder);
        val btnSalir: Button = findViewById(R.id.btnSalir);
        val btnRegistrar: Button = findViewById(R.id.btnRegistrar);

        btnAcceder.setOnClickListener{
            val loginScreen = Intent(this, LoginActivity::class.java)
            startActivity(loginScreen)
        };

        btnSalir.setOnClickListener {
            Toast.makeText(this, "Esta intentando salir de la APP", Toast.LENGTH_LONG).show();
        }

        btnRegistrar.setOnClickListener {
            val registroScreen = Intent(this, RegistroActivity::class.java)
            startActivity(registroScreen)
        }
    }
}