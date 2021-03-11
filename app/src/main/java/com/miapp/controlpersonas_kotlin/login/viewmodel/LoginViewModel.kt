package com.miapp.controlpersonas_kotlin.login.viewmodel

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val _progressVisibility = MutableLiveData<Boolean>()
    val progressVisibility : LiveData<Boolean> get() = _progressVisibility

    fun onButtonLoginClicked(){
        validateCredentials()
    }

    fun getProgressVisibility() : MutableLiveData<Boolean>{
        return _progressVisibility
    }

    private fun validateCredentials() {
        viewModelScope.launch{
            _progressVisibility.value = true
            _progressVisibility.value =withContext(Dispatchers.IO){
                Thread.sleep(2000)
                false
            }!!
        }
    }


}