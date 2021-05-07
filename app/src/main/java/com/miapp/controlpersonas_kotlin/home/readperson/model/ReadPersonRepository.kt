package com.miapp.controlpersonas_kotlin.home.readperson.model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface ReadPersonRepository {
    fun getPersonReadApi()
    fun getPersonReadDB(person: Persona?, context: Context): Persona?
}