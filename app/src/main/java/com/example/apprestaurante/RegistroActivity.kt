package com.example.apprestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import  com.example.apprestaurante.BDHelper

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnGrabar : Button = findViewById(R.id.btnGrabarUsuario)
        val btnVolver: Button = findViewById(R.id.btnVolver)
        val btnVer : Button = findViewById(R.id.btnTest)

        btnGrabar.setOnClickListener{
            val inputCorreo : EditText = findViewById(R.id.txtCorreo)
            val inputUsuario : EditText = findViewById(R.id.txtUsuario)
            val inputContrasenia : EditText = findViewById(R.id.txtContrasenia)

            val correo = inputCorreo.text.toString()
            val usuario = inputUsuario.text.toString()
            val contrasenia = inputContrasenia.text.toString()

            val db = BDHelper(this, null)

            db.CrearRegistro(correo, usuario, contrasenia)

            Toast.makeText(this, "Se registro el usuario de manera exitosa", Toast.LENGTH_LONG).show()

            inputCorreo.text.clear()
            inputUsuario.text.clear()
            inputContrasenia.text.clear()
        }

        btnVolver.setOnClickListener {
            val intent = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnVer.setOnClickListener{
            val db = BDHelper(this, null)
            val cursor = db.listarTodoRegistros()

            cursor!!.moveToLast()

            val indiceCorreo = cursor.getColumnIndex("CORREO")
            val correo = cursor.getString(indiceCorreo)
            
            Toast.makeText(this, "Ultimo correo es " + correo, Toast.LENGTH_LONG).show()
        }
    }
}