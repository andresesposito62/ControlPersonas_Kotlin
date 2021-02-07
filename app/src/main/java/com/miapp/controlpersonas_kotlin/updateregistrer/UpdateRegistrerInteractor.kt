package com.miapp.controlpersonas_kotlin.updateregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.createregistrer.ImplementInterfaceCreateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceUpdateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class UpdateRegistrerInteractor {
    interface OnLoginFinishedListener{
        fun onCreateRegistrerError()

        fun onSuccess()
    }

    fun queryToDataBase(persona: Persona, listener: OnLoginFinishedListener, context: Context){

        var implementInterfaceUpdateDatabaseRegistrer = ImplementInterfaceUpdateDatabaseRegistrer()
        var  affectedRegistrers = implementInterfaceUpdateDatabaseRegistrer.actualizarPersona(persona, context)

        if(affectedRegistrers!= -1L){
            listener.onSuccess()
        }else{
            listener.onCreateRegistrerError()
        }
    }
}