package com.miapp.controlpersonas_kotlin.createregistrer.presenter

import android.content.Context
import com.miapp.controlpersonas_kotlin.createregistrer.model.PersonCreateInteractor
import com.miapp.controlpersonas_kotlin.createregistrer.model.PersonCreateInteractorImpl
import com.miapp.controlpersonas_kotlin.createregistrer.view.PersonCreateView
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class PersonCreatePresenterImpl(var personCreateView: PersonCreateView) : PersonCreatePresenter {

    private var personCreateInteractor : PersonCreateInteractor = PersonCreateInteractorImpl(this)

    override fun setPersonCreate(person: Persona?, context: Context) {

        personCreateInteractor.setPersonCreateDb(person, context)
    }

    override fun showResultSuccess() {
        TODO("Not yet implemented")
    }

    override fun showQueryError() {
        TODO("Not yet implemented")
    }

    override fun showDataInputError() {
        TODO("Not yet implemented")
    }

    override fun getResultQuery(resultQuery: Long?) {
        if(resultQuery!= -1L){
            personCreateView.showResultSuccess()
        }else{
            personCreateView.showQueryError()
        }
    }
}