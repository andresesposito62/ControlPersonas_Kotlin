package com.miapp.controlpersonas_kotlin.createregistrer

import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface CreateRegistrerView {
    fun showProgress()
    fun hideProgress()
    fun navigateToActionSelector()
    fun setQueryError()
    fun setValuesEmptyError()
    fun setSucces()
}