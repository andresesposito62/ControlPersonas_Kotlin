package com.miapp.controlpersonas_kotlin.registerperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceCreateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class RegisterPersonRepositoryImpl() : RegisterPersonRepository {

    private var  resultQuery : Long? = null

    override fun setRegisterPersonApi() {
        //
    }

    override fun setRegisterPersonDB(person: Persona?, context: Context): Long? {
        var implementInterfaceCreateDatabaseRegistrer : InterfaceCreateDatabaseRegistrer = ImplementInterfaceCreateDatabaseRegistrer()

        try {
            resultQuery = implementInterfaceCreateDatabaseRegistrer.registrarPersona(person!!, context)
        }catch (e : NullPointerException){}
        finally {
            return resultQuery
        }
    }
}
