package com.miapp.controlpersonas_kotlin.createregistrer.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.createregistrer.presenter.PersonCreatePresenter
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class PersonCreateInteractorImpl(var personCreatePresenter: PersonCreatePresenter) : PersonCreateInteractor {

    private var personCreateRepository : PersonCreateRepository = PersonCreateRepositoryImpl(personCreatePresenter)

    override fun setPersonCreateApi() {
        TODO("Not yet implemented")
    }

    override fun setPersonCreateDb(person: Persona?, context: Context) {
        personCreateRepository.setPersonCreateDb(person, context)
    }
}