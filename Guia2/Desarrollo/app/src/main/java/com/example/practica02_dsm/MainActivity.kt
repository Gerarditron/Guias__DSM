package com.example.practica02_dsm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var nombre: EditText
lateinit var enviar: Button
lateinit var resultado: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.txtNombre)
        enviar = findViewById(R.id.btnEnviar)
        resultado = findViewById(R.id.lbResultado)

        enviar.setOnClickListener{
            var nombreUsuario: String = nombre.text.toString()
            resultado.setText(nombreUsuario)
        }



    }
}