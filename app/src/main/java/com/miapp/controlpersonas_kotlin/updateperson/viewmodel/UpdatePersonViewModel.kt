package com.miapp.controlpersonas_kotlin.updateperson.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.controlpersonas_kotlin.updateperson.model.UpdatePersonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.launch

class UpdatePersonViewModel : ViewModel() {
    private var statusQuery = MutableLiveData<Boolean>()
    private var updatePersonObservableObservable: UpdatePersonObservable = UpdatePersonObservable()
    private var initQuery = MutableLiveData<Boolean>()

    fun setUpdatePerson(person: Persona, context: Context){
        viewModelScope.launch {
            //dataPersonReaded.value = personReadObservable.getPersonReadDB(person, context)
            statusQuery.value = updatePersonObservableObservable.setPersonUpdateDb(person, context)
        }
    }

    fun getStatusQuery(): LiveData<Boolean> {
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