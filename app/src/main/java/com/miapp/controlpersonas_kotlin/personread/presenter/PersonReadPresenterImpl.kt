package com.miapp.controlpersonas_kotlin.personread.presenter

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.model.PersonReadInteractor
import com.miapp.controlpersonas_kotlin.personread.model.PersonReadInteractorImpl
import com.miapp.controlpersonas_kotlin.personread.view.PersonReadView

class PersonReadPresenterImpl(var personReadView: PersonReadView) : PersonReadPresenter {

    private var personaReadInteractor : PersonReadInteractor = PersonReadInteractorImpl(this)

    override fun showPersonRead(person : Persona?) {
        personReadView.showPersonRead(person)
    }

    override fun getPersonRead(person : Persona?, context: Context) {
        personaReadInteractor.getPersonReadDB(person, context)
    }
}