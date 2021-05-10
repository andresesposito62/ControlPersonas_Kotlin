package com.miapp.controlpersonas_kotlin.readperson.model

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ReadPersonObservable: BaseObservable() {
    private var readPersonRepositoryImpl: ReadPersonRepository = ReadPersonRepositoryImpl()

    fun getPersonReadDB(person: Persona?, context: Context): Persona?{
        return readPersonRepositoryImpl.getPersonReadDB(person, context)
    }
}