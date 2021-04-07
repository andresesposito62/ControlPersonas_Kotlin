package com.miapp.controlpersonas_kotlin.updateregistrer.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.updateregistrer.model.PersonUpdateObservable
import kotlinx.coroutines.launch

class PersonUpdateViewModel : ViewModel() {

    private var statusQuery = MutableLiveData<Boolean>()
    private var personUpdateObservable: PersonUpdateObservable = PersonUpdateObservable()
    private var personUi = MutableLiveData<Persona>()
    private var initQuery = MutableLiveData<Boolean>()

    fun getStatusQuery(): MutableLiveData<Boolean>{
        return statusQuery
    }

    fun getInitQuery(): MutableLiveData<Boolean>{
        return initQuery
    }

    fun setPersonUpdate(person: Persona?, context: Context){
        viewModelScope.launch {
            statusQuery.value = personUpdateObservable.setPersonUpdateDb(person, context).value
        }
    }

    fun onButtonLoginClicked(){
         initQuery.value = true
    }

    fun endQuery(){
        initQuery.value = false
    }
}