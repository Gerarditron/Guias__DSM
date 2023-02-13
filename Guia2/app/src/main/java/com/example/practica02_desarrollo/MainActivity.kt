package com.example.practica02_desarrollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre =  findViewById(R.id.txtNombre)
        enviar = findViewById(R.id.btnEnviar)
        resultado = findViewById(R.id.lbResultado)



    }
}