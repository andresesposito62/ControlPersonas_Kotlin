package com.miapp.controlpersonas_kotlin.createregistrer.presenter

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonCreatePresenter {
    fun setPersonCreate(person : Persona?, context: Context)
    fun showResultSuccess()
    fun showQueryError()
    fun showDataInputError()
    fun getResultQuery(resultQuery: Long?)
}