package com.miapp.controlpersonas_kotlin.personread.presenter

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.model.PersonReadInteractor
import com.miapp.controlpersonas_kotlin.personread.model.PersonReadInteractorImpl
import com.miapp.controlpersonas_kotlin.personread.view.PersonReadView

class PersonReadPresenterImpl(var personReadView: PersonReadView) : PersonReadPresenter {

    private var personaReadInteractor : PersonReadInteractor = PersonReadInteractorImpl(this)

    override fun showPersonRead(person : Persona?) {
        if (!person?.getIdentificacion().toString().isNullOrEmpty() &&
            !person?.getNombres().toString().isNullOrEmpty() &&
            !person?.getApellidos().toString().isNullOrEmpty() &&
            !person?.getTelefono().toString().isNullOrEmpty() &&
            !person?.getTemperatura().toString().isNullOrEmpty() &&
            !person?.getRol().toString().isNullOrEmpty()) {

                personReadView.showPersonRead(person)
        }else{
            personReadView.setQueryError()
        }
    }

    override fun getPersonRead(person : Persona?, context: Context) {
        if(!person?.getIdentificacion().isNullOrEmpty()){
            personaReadInteractor.getPersonReadDB(person, context)
        }else{
            personReadView.setIdentificationError()
        }
    }
}