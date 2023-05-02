package com.example.appcalculadoramvc

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcalculadoramvc.ui.theme.AppCalculadoraMvcTheme
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var controller: CalculatorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Crear el controlador y pasarle la vista
        controller = CalculatorController(this)
    }

    fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    fun showSnacknar(message: String){
        Snackbar.make(findViewById(android.R.id.content),message, Snackbar.LENGTH_SHORT).show()
    }


}
