package com.miapp.controlpersonas_kotlin.home.readperson.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.controlpersonas_kotlin.home.readperson.model.ReadPersonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.launch

class ReadPersonViewModel : ViewModel() {
    private var dataPersonReaded = MutableLiveData<Persona?>()
    private var personReadObservable: ReadPersonObservable = ReadPersonObservable()

    fun getDataPersonReaded(): LiveData<Persona?> {
        return dataPersonReaded
    }

    fun initQuery(person: Persona, context: Context){
        viewModelScope.launch {
            dataPersonReaded =  personReadObservable.getPersonReadDB(person, context)
        }
    }
}