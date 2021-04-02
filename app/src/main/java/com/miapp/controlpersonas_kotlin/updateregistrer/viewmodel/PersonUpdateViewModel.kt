package com.miapp.controlpersonas_kotlin.updateregistrer.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.updateregistrer.model.PersonUpdateObservable

class PersonUpdateViewModel : ViewModel() {

    private var statusQuery = MutableLiveData<Boolean>()
    private var personUpdateObservable: PersonUpdateObservable = PersonUpdateObservable()

    fun getStatusQuery(): MutableLiveData<Boolean>{
        return statusQuery
    }

    fun setPersonUpdate(person: Persona?, context: Context){
        statusQuery.value = personUpdateObservable.setPersonUpdateDb(person, context).value
    }
}