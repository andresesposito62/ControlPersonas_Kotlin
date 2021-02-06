package com.miapp.controlpersonas_kotlin.readregistrer

import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface ReadRegistrerView {
    fun showProgress()
    fun hideProgress()
    fun setidentificationError()
    fun navigateToActionSelector()
    fun setQueryError()
    fun setDates(persona: Persona)
    fun setIdentificationEmptyError()
}