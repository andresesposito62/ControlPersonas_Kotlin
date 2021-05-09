package com.miapp.controlpersonas_kotlin.home.registerperson.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.controlpersonas_kotlin.home.readperson.model.ReadPersonObservable
import com.miapp.controlpersonas_kotlin.home.registerperson.model.RegisterPersonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.launch

class RegisterPersonViewModel : ViewModel() {
    private var statusQuery = MutableLiveData<Long>()
    private var registerPersonObservableObservable: RegisterPersonObservable = RegisterPersonObservable()
    private var initQuery = MutableLiveData<Boolean>()

    fun setRegisterPerson(person: Persona, context: Context){
        viewModelScope.launch {
            //dataPersonReaded.value = personReadObservable.getPersonReadDB(person, context)
            statusQuery.value = registerPersonObservableObservable.setRegisterPerson(person, context)
        }
    }

    fun getStatusQuery(): LiveData<Long> {
        return statusQuery
    }

    fun getInitQuery(): LiveData<Boolean> {
        return initQuery
    }

    fun onButtonLoginClicked(){
        initQuery.value = true
    }

    fun endQuery(){
        initQuery.value = false
    }
}