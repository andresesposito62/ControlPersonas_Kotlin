package com.miapp.controlpersonas_kotlin.readregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.datos.AdminSQLiteOpenHelper
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceReadFromDataBase
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ImplementsInterfaceReadFromDataBase : InterfaceReadFromDataBase {

    override fun readRegistrerFromDataBase(persona: Persona, context: Context): Persona{
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
        /*persona.setNombres("Andres")
        persona.setApellidos("Esposito")
        persona.setTelefono("1234546")
        persona.setTemperatura("38.6")*/
        return persona
    }
}