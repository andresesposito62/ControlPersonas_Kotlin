package com.miapp.controlpersonas_kotlin.home.deleteperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class DeletePersonRepositoryImpl: DeletePersonRepository {

    private var statusQuery : Boolean? = null
    private var affectedRegisters: Long? = null

    override fun setDeletePersonApi() {
        TODO("Not yet implemented")
    }

    override fun setDeletePersonDB(person: Persona?, context: Context): Boolean? {

        var implementsInterfaceDeleteFromDataBase = ImplementInterfaceDeleteDatabaseRegistrer()

        try {
            affectedRegisters = implementsInterfaceDeleteFromDataBase.eliminarPersona(person!!, context)
        }catch (e : NullPointerException){}

        finally {
            if(affectedRegisters!= -1L){
                statusQuery = true
            }else{
                statusQuery = false
            }
            return statusQuery
        }
    }
}