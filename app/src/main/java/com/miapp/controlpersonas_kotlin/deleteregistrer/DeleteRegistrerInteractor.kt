package com.miapp.controlpersonas_kotlin.deleteregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.readregistrer.ImplementInterfaceReadDatabaseRegistrer

class DeleteRegistrerInteractor {

    interface OnLoginFinishedListener{
        fun onIdentificationError()

        fun onSuccess()
    }

    fun queryToDataBase(persona: Persona, listener: OnLoginFinishedListener, context: Context){

        var implementsInterfaceDeleteFromDataBase = ImplementInterfaceDeleteDatabaseRegistrer()
        var  affectedRegistrers = implementsInterfaceDeleteFromDataBase.eliminarPersona(persona, context)

        if(affectedRegistrers!= -1L){
            listener.onSuccess()
        }else{
            listener.onIdentificationError()
        }
    }
}