package com.miapp.controlpersonas_kotlin.updateregistrer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonUpdateViewModel : ViewModel() {

    private var statusQuery = MutableLiveData<Boolean>()

    fun getStatusQuery(): MutableLiveData<Boolean>{
        return statusQuery
    }

    fun querySuccess(){
        statusQuery.value = true
    }

    fun queryFailed(){
        statusQuery.value = false
    }

}