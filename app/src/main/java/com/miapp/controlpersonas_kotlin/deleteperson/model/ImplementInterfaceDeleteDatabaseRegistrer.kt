package com.miapp.controlpersonas_kotlin.deleteperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.datos.AdminSQLiteOpenHelper
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceDeleteDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ImplementInterfaceDeleteDatabaseRegistrer : InterfaceDeleteDatabaseRegistrer {

    override fun eliminarPersona(persona: Persona, context: Context): Long {
        val admin = AdminSQLiteOpenHelper(context, "administracion12", null, 1)
        val BaseDeDatos = admin.writableDatabase
        var cantidad: Long = 0
        val identificacion = persona.getIdentificacion()
        if (!identificacion!!.isEmpty()) {
            cantidad = BaseDeDatos.delete("personas", "identificacion=$identificacion", null).toLong()
            BaseDeDatos.close()
        }
        return cantidad
    }
}