package com.miapp.controlpersonas_kotlin.login

class LoginPresenter : LoginInteractor.OnLoginFinishedListener {

    private var loginView: LoginView? = null
    private var loginInteractor : LoginInteractor? = null

    constructor(loginView: LoginView, loginInteractor: LoginInteractor){
        this.loginView = loginView
        this.loginInteractor = loginInteractor
    }

    fun validateCredentials(username: String, password: String){
        if(loginView != null){
            loginView?.showProgress()
        }
        loginInteractor?.login(username, password, this)
    }

    fun onResume() {
        if (loginView!= null) {
            //loginView.showProgress()
        }
        //findItemsInteractor.findItems({ items: List<String?>? -> this.onFinished(items) })
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