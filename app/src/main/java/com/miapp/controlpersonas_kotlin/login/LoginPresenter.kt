package com.miapp.controlpersonas_kotlin.login

class LoginPresenter : LoginInteractor.OnLoginFinishedListener {

    private var loginView: LoginActivity? = null
    private var loginInteractor : LoginInteractor? = null

    constructor(loginView: LoginActivity, loginInteractor: LoginInteractor){
        this.loginView = loginView
        this.loginInteractor = loginInteractor
    }

    interface LoginInterface {
        fun showProgress()
        fun hideProgress()
        fun setUsernameError()
        fun setPasswordError()
        fun navigateToHome()
    }

    fun validateCredentials(username: String, password: String){
        if(loginView != null){
            loginView?.showProgress()
        }
        loginInteractor?.login(username, password, this)
    }

    fun onResume() {
        if (loginView!= null) {
            loginView?.hideProgress()
        }
    }

    override fun onUsernameError(){
        if(loginView != null){
            loginView?.setUsernameError()
            loginView?.hideProgress()
        }
    }

    override fun onPasswordError(){
        if(loginView != null){
            loginView?.setPasswordError()
            loginView?.hideProgress()
        }
    }

    override fun onSuccess(){
        loginView?.navigateToHome()
    }
}