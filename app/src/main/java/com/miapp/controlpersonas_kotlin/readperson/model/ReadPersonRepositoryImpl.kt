package com.miapp.controlpersonas_kotlin.readperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class ReadPersonRepositoryImpl (): ReadPersonRepository {

    private var personResult : Persona? = null

    override fun getPersonReadApi() {
        TODO("Not yet implemented")
    }

    override fun getPersonReadDB(person: Persona?, context: Context): Persona? {

        var implementInterfaceReadDatabaseRegistrer = ImplementInterfaceReadDatabaseRegistrer()

        try {
            personResult= implementInterfaceReadDatabaseRegistrer.readRegistrerFromDataBase(person!!, context)
        }catch (e : NullPointerException){}

        finally {
            return personResult
        }
    }
}