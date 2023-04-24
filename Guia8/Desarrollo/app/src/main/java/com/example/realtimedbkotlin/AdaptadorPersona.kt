package com.example.realtimedbkotlin

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.realtimedbkotlin.datos.Persona

class AdaptadorPersona(private val context: AppCompatActivity, var personas: List<Persona>):
    ArrayAdapter<Persona?>(context, R.layout.persona_layout, personas) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View{
            //Metodo invocado tantas veces como elementos tenga la coleccion personas
            // para formar a cada item que se visualizara en la lista personalizada
            val layoutInflater = context.layoutInflater
            var rowview: View? = null
            //optimizando las diversas llamadas que se realizan a este metodo
            // pues a partir de la segunda llamada el objeto view ya viene formado
            // y no sera necesario hacer el proceso de "inflado" que conlleva tiempo y
            // desgaste de bateria del dispositivo
            rowview = view?:layoutInflater.inflate(R.layout.persona_layout,null)
            val tvNombre = rowview!!.findViewById<TextView>(R.id.tvNombre)
            val tvDUI = rowview!!.findViewById<TextView>(R.id.tvDUI)
            tvNombre.text = "Nombre: "+personas[position].nombre
            tvDUI.text = "DUI: " +personas[position].dui
            return rowview

        }




}