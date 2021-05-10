package com.miapp.controlpersonas_kotlin.readperson.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.controlpersonas_kotlin.readperson.model.ReadPersonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.launch

class ReadPersonViewModel : ViewModel() {
    private var dataPersonReaded = MutableLiveData<Persona?>()
    private var personReadObservable: ReadPersonObservable = ReadPersonObservable()
    private var initQuery = MutableLiveData<Boolean>()

    fun queryDataPerson(person: Persona, context: Context){
        viewModelScope.launch {
            dataPersonReaded.value = personReadObservable.getPersonReadDB(person, context)
        }
    }

    fun getDataPersonReaded(): LiveData<Persona?> {
        return dataPersonReaded
    }

    fun getInitQuery(): LiveData<Boolean>{
        return initQuery
    }

    fun onButtonLoginClicked(){
        initQuery.value = true
    }

    fun endQuery(){
        initQuery.value = false
    }
}