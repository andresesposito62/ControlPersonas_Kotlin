package com.miapp.controlpersonas_kotlin.updateregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class UpdateRegistrerInteractor {

    fun queryToDataBase(persona: Persona, context: Context) : Boolean{

        var status = false
        var implementInterfaceUpdateDatabaseRegistrer = ImplementInterfaceUpdateDatabaseRegistrer()
        var  affectedRegistrers = implementInterfaceUpdateDatabaseRegistrer.actualizarPersona(persona, context)

        if(affectedRegistrers!= -1L){
            status = true
        }else{
            status = false
        }
        return status
    }
}