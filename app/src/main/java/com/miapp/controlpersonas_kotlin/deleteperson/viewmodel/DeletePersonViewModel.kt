package com.miapp.controlpersonas_kotlin.deleteperson.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.controlpersonas_kotlin.deleteperson.model.DeletePersonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.launch

class DeletePersonViewModel : ViewModel() {
    private var statusQuery = MutableLiveData<Boolean>()
    private var deletePersonObservable: DeletePersonObservable = DeletePersonObservable()
    private var initQuery = MutableLiveData<Boolean>()

    fun setQueryDeletePerson(person: Persona, context: Context){
        viewModelScope.launch {
            statusQuery.value = deletePersonObservable.setDeletePersonDB(person, context)
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