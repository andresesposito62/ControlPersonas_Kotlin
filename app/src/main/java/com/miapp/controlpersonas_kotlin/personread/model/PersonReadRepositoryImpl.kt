package com.miapp.controlpersonas_kotlin.personread.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.createregistrer.ImplementInterfaceCreateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceReadDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.presenter.PersonReadPresenter

class PersonReadRepositoryImpl (var personReadPresenter: PersonReadPresenter): PersonReadRepository {

    override fun getPersonReadApi() {
        TODO("Not yet implemented")
    }

    override fun getPersonReadDB(person: Persona?, context: Context) {
        var implementInterfaceReadDatabaseRegistrer = ImplementInterfaceReadDatabaseRegistrer()
        var  personResult = implementInterfaceReadDatabaseRegistrer.readRegistrerFromDataBase(person!!, context)
        personReadPresenter.showPersonRead(personResult)
    }
}