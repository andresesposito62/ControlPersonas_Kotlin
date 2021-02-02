package com.miapp.controlpersonas_kotlin.modelo.datos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(BaseDeDatos: SQLiteDatabase) {
        BaseDeDatos.execSQL("create table personas(id_persona INTEGER PRIMARY KEY AUTOINCREMENT, identificacion text, nombres text, apellidos text, telefono text, temperatura text, rol text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}