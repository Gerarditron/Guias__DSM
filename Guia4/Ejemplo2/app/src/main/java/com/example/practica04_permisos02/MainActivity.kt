package com.example.practica04_permisos02

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "Practica 04 - Permisos"
    private val CODIGOSOLICITUDGRABAR = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configurarPermisos()
    }

    private fun configurarPermisos() {
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)
        if(permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permiso denegado para grabar")
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.RECORD_AUDIO
                )
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Permiso para acceder al microfono es requerido para esta App para grabar Audio")
                builder.setTitle("Permission Required")
                builder.setPositiveButton("OK") { dialog, id ->
                    Log.i(TAG, "Seleccionado")
                    hacerSolicitudPermiso()
                }
                val dialog = builder.create()
                dialog.show()
            } else {
                hacerSolicitudPermiso()
            }
        }

    }

    private fun hacerSolicitudPermiso() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO),CODIGOSOLICITUDGRABAR)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode , permissions, grantResults)
        when(requestCode){
            CODIGOSOLICITUDGRABAR -> {
                if(grantResults.isEmpty() || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED){
                    Log.i(TAG, "Permiso a sido denegado por el usuario")
                    Toast.makeText(applicationContext, "Permiso a sido denegado por el usuario", Toast.LENGTH_SHORT).show()
                    /* Escribir el codigo de permiso denegado, segun se requiera */
                } else {
                    Log.i(TAG, "Permiso concedido por el usuario")
                    Toast.makeText(applicationContext,"Permiso concedido por el usuario", Toast.LENGTH_SHORT).show()
                    /* Escribir el codigo de permiso concedido segun se requiera */
                }
            }
        }
    }



}