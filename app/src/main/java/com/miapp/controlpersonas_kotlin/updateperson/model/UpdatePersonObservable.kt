package com.miapp.controlpersonas_kotlin.updateperson.model

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class UpdatePersonObservable: BaseObservable() {

    private var updatePersonRepository : UpdatePersonRepository = UpdatePersonRepositoryImpl()

    //For Repository
    fun setPersonUpdateApi(){
    }

    suspend fun setPersonUpdateDb(person : Persona?, context: Context): Boolean?{
        return updatePersonRepository.updateRegisterPersonDbRoom(person, context)
        //return updatePersonRepository.setPersonUpdateDb(person, context)
    }
}