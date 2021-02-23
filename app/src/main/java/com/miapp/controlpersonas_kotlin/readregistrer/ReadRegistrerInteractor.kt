package com.miapp.controlpersonas_kotlin.readregistrer

import android.content.Context
import android.os.Handler
import android.text.TextUtils
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ReadRegistrerInteractor {

    fun queryToDataBase(persona: Persona, context: Context): Persona?{

        var implementsInterfaceReadFromDataBase = ImplementInterfaceReadDatabaseRegistrer()
        var  personaResult = implementsInterfaceReadFromDataBase.readRegistrerFromDataBase(persona, context)

        if(personaResult.getNombres() != "" && personaResult.getApellidos() != "" && personaResult.getTelefono() != ""
                && personaResult.getTemperatura() != "" && personaResult.getRol() != ""){
             return personaResult

        }else{
            return null
        }
    }
}