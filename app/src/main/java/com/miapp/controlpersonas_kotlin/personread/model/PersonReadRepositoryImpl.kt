package com.miapp.controlpersonas_kotlin.personread.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.presenter.PersonReadPresenter
import java.lang.NullPointerException

class PersonReadRepositoryImpl (var personReadPresenter: PersonReadPresenter): PersonReadRepository {

    private var personResult : Persona? = null

    override fun getPersonReadApi() {
        TODO("Not yet implemented")
    }

    override fun getPersonReadDB(person: Persona?, context: Context) {
        var implementInterfaceReadDatabaseRegistrer = ImplementInterfaceReadDatabaseRegistrer()
        try {
            personResult = implementInterfaceReadDatabaseRegistrer.readRegistrerFromDataBase(person!!, context)
        }catch (e : NullPointerException){}
        finally {
            personReadPresenter.showPersonRead(personResult)
        }
    }
}