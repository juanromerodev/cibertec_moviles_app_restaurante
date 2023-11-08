package com.example.apprestaurante

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDHelper (context: Context, factory: SQLiteDatabase.CursorFactory) : SQLiteOpenHelper (context, DATABASE_NAME, factory, DATABASE_VERSION){
    companion object {
        private val DATABASE_NAME = "BD_Restaurante"
        private val DATABASE_VERSION = 1
        private val TABLA_USUARIOS = "USUARIO"
        private val COLUMN_ID = "IDUSER"
        private val COLUMN_CORREO = "CORREO"
        private val COLUMN_USUARIO = "USUARIO"
        private val COLUMN_CONTRASENIA = "CONTRASENIA"
    }

    override fun onCreate(db: SQLiteDatabase) {
        var queryCreateTable =
            ("CREATE TABLE " + TABLA_USUARIOS + " ( " +
                    COLUMN_ID + " INT PRIMARY KEY," +
                    COLUMN_CORREO + " TEXT," +
                    COLUMN_USUARIO + " TEXT," +
                    COLUMN_CONTRASENIA + " TEXT" + " )"
                    )
        db.execSQL(queryCreateTable)
        db.close()
    }

    fun CrearRegistro (correo:String, usuario:String, contrasenia:String){
        val values = ContentValues();

        values.put(COLUMN_USUARIO,usuario)
        values.put(COLUMN_CORREO,correo)
        values.put(COLUMN_CONTRASENIA,contrasenia)

        val db = this.writableDatabase

        db.insert(TABLA_USUARIOS,null,values)
        db.close()
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}