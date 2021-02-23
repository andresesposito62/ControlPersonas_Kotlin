package com.miapp.controlpersonas_kotlin.createregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.readregistrer.ImplementInterfaceReadDatabaseRegistrer

class CreateRegistrerInteractor {

    fun queryToDataBase(persona: Persona, context: Context): Boolean{
        var status = false
        var implementInterfaceCreateDatabaseRegistrer = ImplementInterfaceCreateDatabaseRegistrer()
        var  affectedRegistrers = implementInterfaceCreateDatabaseRegistrer.registrarPersona(persona, context)

        if(affectedRegistrers!= -1L){
            status = true
        }else{
            status = false
        }
        return status
    }
}