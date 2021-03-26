package com.miapp.controlpersonas_kotlin.personread.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.presenter.PersonReadPresenter

class PersonReadInteractorImpl(var personReadPresenter : PersonReadPresenter) : PersonReadInteractor {

    private var personReadRepository : PersonReadRepository = PersonReadRepositoryImpl(personReadPresenter)

    override fun getPersonReadApi() {
        TODO("Not yet implemented")
    }

    override fun getPersonReadDB(person: Persona?, context: Context) {
        personReadRepository.getPersonReadDB(person, context)
    }
}