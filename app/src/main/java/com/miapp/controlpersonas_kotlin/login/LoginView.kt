package com.miapp.controlpersonas_kotlin.login

interface LoginView {

    fun showProgress()

    fun hideProgress()

    fun setUsernameError()

    fun setPasswordError()

    fun navigateToHome()
}