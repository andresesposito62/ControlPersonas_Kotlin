package com.miapp.controlpersonas_kotlin.personread.presenter

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.model.PersonReadInteractor
import com.miapp.controlpersonas_kotlin.personread.model.PersonReadInteractorImpl
import com.miapp.controlpersonas_kotlin.personread.view.PersonReadView

class PersonReadPresenterImpl(var personReadView: PersonReadView) : PersonReadPresenter {

    private var personaReadInteractor : PersonReadInteractor = PersonReadInteractorImpl(this)
    private var personReadLiveData = MutableLiveData<Persona?>()

    override fun showPersonRead(person : Persona?) {
        if (!person?.getIdentificacion().toString().isNullOrEmpty() &&
            !person?.getNombres().toString().isNullOrEmpty() &&
            !person?.getApellidos().toString().isNullOrEmpty() &&
            !person?.getTelefono().toString().isNullOrEmpty() &&
            !person?.getTemperatura().toString().isNullOrEmpty() &&
            !person?.getRol().toString().isNullOrEmpty()) {

                //personReadView.showPersonRead(person)
            personReadLiveData.value = person
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

    override fun getPersonReadLiveData(): LiveData<Persona?> {
        return personReadLiveData
    }
}