package com.miapp.controlpersonas_kotlin.createregistrer.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.createregistrer.presenter.PersonCreatePresenter
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceCreateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class PersonCreateRepositoryImpl(var personCreatePresenter: PersonCreatePresenter) : PersonCreateRepository {

    private var  resultQuery : Long? = null

    override fun setPersonCreateApi() {
        TODO("Not yet implemented")
    }

    override fun setPersonCreateDb(person: Persona?, context: Context) {
        var implementInterfaceCreateDatabaseRegistrer : InterfaceCreateDatabaseRegistrer = ImplementInterfaceCreateDatabaseRegistrer()

        try {
            resultQuery = implementInterfaceCreateDatabaseRegistrer.registrarPersona(person!!, context)
        }catch (e : NullPointerException){}
        finally {
            personCreatePresenter.getResultQuery(resultQuery)
        }
    }
}