package com.miapp.controlpersonas_kotlin.createregistrer

interface CreateRegistrerView {
    fun showProgress()
    fun hideProgress()
    fun setidentificationError()
    fun setNamesError()
    fun setSurnamesError()
    fun setPhoneError()
    fun setTemperatureError()
    fun navigateToActionSelector()
}