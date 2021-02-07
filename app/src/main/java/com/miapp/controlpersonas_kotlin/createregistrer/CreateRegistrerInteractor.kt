package com.miapp.controlpersonas_kotlin.createregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.readregistrer.ImplementInterfaceReadDatabaseRegistrer

class CreateRegistrerInteractor {

    interface OnLoginFinishedListener{
        fun onCreateRegistrerError()

        fun onSuccess()
    }

    fun queryToDataBase(persona: Persona, listener: OnLoginFinishedListener, context: Context){

        var implementInterfaceCreateDatabaseRegistrer = ImplementInterfaceCreateDatabaseRegistrer()
        var  affectedRegistrers = implementInterfaceCreateDatabaseRegistrer.registrarPersona(persona, context)

        if(affectedRegistrers!= -1L){
            listener.onSuccess()
        }else{
            listener.onCreateRegistrerError()
        }
    }
}