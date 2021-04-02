package com.miapp.controlpersonas_kotlin.updateregistrer.model

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class PersonUpdateObservable: BaseObservable() {

    private var personUpdateRepository : PersonUpdateRepository = PersonUpdateRepositoryImpl()

    //For Repository
    fun setPersonUpdateApi(){

    }

    fun setPersonUpdateDb(person : Persona?, context: Context): MutableLiveData<Boolean>{
        return personUpdateRepository.setPersonUpdateDb(person, context)
    }

    //For ViewModel

}