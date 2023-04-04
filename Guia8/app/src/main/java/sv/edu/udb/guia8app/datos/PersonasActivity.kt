package sv.edu.udb.guia8app.datos

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompact.app.AppCompatActivity
import android.support.v7.app.AppCompatActivity


class PersonasActivity: AppCompatActivity() {
    //Ordenamiento para hacer la consultas a los datos
    var consultaOrdenada:Query = refPersonas.orderByChild("nombre")
}