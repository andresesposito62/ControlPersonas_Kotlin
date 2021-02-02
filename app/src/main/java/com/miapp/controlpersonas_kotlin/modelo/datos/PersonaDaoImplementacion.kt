package com.miapp.controlpersonas_kotlin.modelo.datos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona


class PersonaDaoImplementacion : InterfazPersonaDao{

    fun PersonaDaoImplementacion() {

    }

    override fun registrarPersona(persona: Persona, context: Context): Long {
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
            var registro = ContentValues()
            registro.put("identificacion", identificacion)
            registro.put("nombres", nombres)
            registro.put("apellidos", apellidos)
            registro.put("telefono", telefono)
            registro.put("temperatura", temperatura)
            registro.put("rol", rol)
            registrosAfectados = BaseDeDatos.insert("personas", null, registro)
            BaseDeDatos.close()
        }
        return registrosAfectados
    }

    override fun consultarPersona(persona: Persona, context: Context): Persona {
        var identificacion = persona.getIdentificacion()
        var admin = AdminSQLiteOpenHelper(context, "administracion12", null, 1)
        var BaseDeDatos = admin.writableDatabase
        if (identificacion != "" ) {
            var fila = BaseDeDatos.rawQuery("select nombres, apellidos, telefono, temperatura, rol from personas where identificacion="+identificacion,null)

            if (fila.moveToFirst()) {
                persona.setNombres(fila.getString(0))
                persona.setApellidos(fila.getString(1))
                persona.setTelefono(fila.getString(2))
                persona.setTemperatura(fila.getString(3))
                persona.setRol(fila.getString(4))
                persona.setIdentificacion(identificacion)
                //consulta exitosa
                BaseDeDatos.close()
            } else {
                //consulta no exitosa
                persona.setNombres("")
                persona.setApellidos("")
                persona.setTelefono("")
                persona.setTemperatura("")
                persona.setRol("")
                persona.setIdentificacion("")
                BaseDeDatos.close()
            }
        } else {
            //consulta no exitosa
            persona.setNombres("")
            persona.setApellidos("")
            persona.setTelefono("")
            persona.setTemperatura("")
            persona.setRol("")
            persona.setIdentificacion("")
        }
        return persona
    }


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