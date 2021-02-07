package com.miapp.controlpersonas_kotlin.updateregistrer

interface UpdateRegistrerView {
    fun showProgress()
    fun hideProgress()
    fun navigateToActionSelector()
    fun setQueryError()
    fun setValuesEmptyError()
    fun setSucces()
}