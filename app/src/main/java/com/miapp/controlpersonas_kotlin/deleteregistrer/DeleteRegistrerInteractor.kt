package com.miapp.controlpersonas_kotlin.deleteregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class DeleteRegistrerInteractor {


    fun queryToDataBase(persona: Persona, context: Context) : Boolean{

        var status = false
        var implementsInterfaceDeleteFromDataBase = ImplementInterfaceDeleteDatabaseRegistrer()
        var  affectedRegistrers = implementsInterfaceDeleteFromDataBase.eliminarPersona(persona, context)

        if(affectedRegistrers!= -1L){
            status = true
        }else{
            status = false
        }
        return status
    }
}