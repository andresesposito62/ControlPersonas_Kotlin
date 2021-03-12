package com.miapp.controlpersonas_kotlin.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.controlpersonas_kotlin.login.LoginInteractor
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel(), LoginInteractor.OnLoginFinishedListener {

    private val _progressVisibility = MutableLiveData<Boolean>()
    val progressVisibility : LiveData<Boolean> get() = _progressVisibility

    var userEmail= ""
    var userPass = ""


    private var loginInteractor =LoginInteractor()

    fun onButtonLoginClicked(){
        validateCredentials()
    }

    fun getProgressVisibility() : MutableLiveData<Boolean>{
        return _progressVisibility
    }

    private fun validateCredentials() {
        _progressVisibility.value = true
        viewModelScope.launch{

            if(userEmail.isNotEmpty() && userPass.isNotEmpty()){

                loginInteractor.login(userEmail, userPass,this@LoginViewModel)
            }else{
                setError()
            }
        }
    }

    fun setError(){
        _progressVisibility.value = false
    }

    override fun onUsernameError() {
        _progressVisibility.value = false
    }

    override fun onPasswordError() {
        _progressVisibility.value = false
    }

    override fun onSuccess() {
        _progressVisibility.value = false
    }


}