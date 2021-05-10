package com.miapp.controlpersonas_kotlin.updateperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceUpdateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class UpdatePersonRepositoryImpl : UpdatePersonRepository {

    private var statusQuery: Boolean? = null
    private var resultQuery : Long? = null

    override fun setPersonUpdateApi() {
        TODO("Not yet implemented")
    }

    override fun setPersonUpdateDb(person: Persona?, context: Context): Boolean? {


        var implementInterfaceUpdateDatabaseRegistrer : InterfaceUpdateDatabaseRegistrer = ImplementInterfaceUpdateDatabaseRegistrer()

        try {
            resultQuery= implementInterfaceUpdateDatabaseRegistrer.actualizarPersona(person!!, context)
        }catch (e : NullPointerException){}
        finally {
            if (resultQuery != -1L){
                statusQuery = true
            }else{
                statusQuery = false
            }
            return statusQuery
        }
    }
}