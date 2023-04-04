package sv.edu.udb.guia8app.datos

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import sv.edu.udb.guia8app.datos.Persona


class PersonasActivity: AppCompatActivity() {
    //Ordenamiento para hacer la consultas a los datos
    //var consultaOrdenada:Query = refPersona.orderByChild("nombre")
    var persona: MutableList<Persona>?=null
    var listaPersonas:ListView?=null

    protected override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_personas)
        inicializar()
    }

    private fun inicializar(){
        //val fab_agregar:FloatingActionButton=findViewById<FloatingActionButton>(R.id.fab_agregar)
        //listaPersonas = findViewById<ListView>(R.id.ListaPersonas)
    }


}