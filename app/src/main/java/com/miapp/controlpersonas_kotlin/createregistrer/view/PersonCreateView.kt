package com.miapp.controlpersonas_kotlin.createregistrer.view

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonCreateView {
    fun setPersonCreate(person: Persona?, context: Context)
    fun showResultSuccess()
    fun showQueryError()
    fun showDataInputError()
}