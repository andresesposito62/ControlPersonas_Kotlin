package com.miapp.controlpersonas_kotlin.updateperson.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.miapp.controlpersonas_kotlin.modelo.datos.AdminSQLiteOpenHelper
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceUpdateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ImplementInterfaceUpdateDatabaseRegistrer : InterfaceUpdateDatabaseRegistrer {

    override fun actualizarPersona(persona: Persona, context: Context): Long {
        var registrosAfectados: Long = 0
        //Metodo Registrar
        var identificacion = persona.getIdentificacion()
        var nombres = persona.getNombres()
        var apellidos = persona.getApellidos()
        var telefono = persona.getTelefono()
        var temperatura = persona.getTemperatura()
        var rol = persona.getRol()
        val admin = AdminSQLiteOpenHelper(context, "administracion12", null, 1)
        val BaseDeDatos = admin.writableDatabase
        if (identificacion != "" && nombres != "" && apellidos != "" && telefono != "" && temperatura != "" &&
                rol != "") {
            val registro = ContentValues()
            registro.put("identificacion", identificacion)
            registro.put("nombres", nombres)
            registro.put("apellidos", apellidos)
            registro.put("telefono", telefono)
            registro.put("temperatura", temperatura)
            registro.put("rol", rol)
            registrosAfectados = BaseDeDatos.update("personas", registro, "identificacion=$identificacion", null).toLong()
            BaseDeDatos.close()
        }
        return registrosAfectados
    }

}