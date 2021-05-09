package com.miapp.controlpersonas_kotlin.home.updateperson.model

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class UpdatePersonObservable: BaseObservable() {

    private var updatePersonRepository : UpdatePersonRepository = UpdatePersonRepositoryImpl()

    //For Repository
    fun setPersonUpdateApi(){
    }

    fun setPersonUpdateDb(person : Persona?, context: Context): Boolean?{
        return updatePersonRepository.setPersonUpdateDb(person, context)
    }
}