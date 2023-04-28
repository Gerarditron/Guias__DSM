package com.example.sqliteapp.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.sqliteapp.db.HelperDB

class Categoria (context: Context?) {

    private var helper: HelperDB? = null
    private var db: SQLiteDatabase? = null

    init {
        helper = HelperDB(context)
        db = helper!!.getWritableDatabase()
    }

    companion object{
        //TABLA PRODUCTOS
        val TABLE_NAME_CATEGORIA = "categoria"

        //Nombre de los campos de la tabla contactos
        val COL_ID = "idcategoria"
        val COL_NOMBRE = "nombre"

        //Sentencia SQL para crear la tabla
        val CREATE_TABLE_CATEGORIA = (
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_CATEGORIA + "("
                    + COL_ID + "integer primary key autoincrement, "
                    + COL_NOMBRE + "varchar() NOT NULL);"
                )
    }

    //ContentValues
    fun generateContentvalues(
        nombre: String?
    ) : ContentValues? {
        val valores = ContentValues()
        valores.put(COL_NOMBRE,nombre)
        return valores
    }

    fun insertValuesDefault() {
        val categories = arrayOf(
            "Abarrotes",
            "Carnes",
            "Embutidos",
            "Mariscos",
            "Pescado",
            "Bebidas",
            "Verduras",
            "Frutas",
            "Bebidas Carbonatadas",
            "Bebidas No Carbonatadas"
        )

        //Verificacion si existen registros precargados

    }


}