package com.miapp.controlpersonas_kotlin.deleteregistrer

import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface DeleteRegistrerView {
    fun showProgress()

    fun hideProgress()

    fun setIdentificationError()

    fun navigateToActionSelector()

    fun setQueryError()

    fun setSucces()

    fun setIdentificationEmptyError()

}