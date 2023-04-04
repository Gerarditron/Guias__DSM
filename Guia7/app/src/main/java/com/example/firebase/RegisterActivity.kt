package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    //Creamos la referencia del objeto de FirebaseAuth
    private lateinit var  auth: FirebaseAuth

    //Referencia a componentes de nuestro Layout
    private lateinit var buttonRegister: Button
    private lateinit var textViewLogin: TextView

    //Escuchador de FirebaseAuth
    private lateinit var  authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializamos el objeto FirebaseAuth
        auth = FirebaseAuth.getInstance()

        buttonRegister = findViewById<Button>(R.id.btnRegister)
        buttonRegister.setOnClickListener{
            val email = findViewById<EditText>(R.id.txtEmail).text.toString()
            val password = findViewById<EditText>(R.id.txtPass).text.toString()
            this.register(email,password)
        }

        textViewLogin = findViewById<TextView>(R.id.textViewLogin)
        textViewLogin.setOnClickListener{
            this.goToLogin()
        }

        //Validar si existe un usuario activo
        this.checkUser()

    }

    override fun onResume(){
        super.onResume()
        auth.addAuthStateListener(authStateListener)
    }

    override fun onPause(){
        super.onPause()
        auth.removeAuthStateListener(authStateListener)
    }

    private fun register(email: String, password: String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {task ->
            if(task.isSuccessful) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    private fun checkUser(){
        //Verificacion del usuario
        authStateListener = FirebaseAuth.AuthStateListener { auth ->
            if (auth.currentUser != null){
                //Cambiando la vista
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }

        }

    }


    private fun goToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}