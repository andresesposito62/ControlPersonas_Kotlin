package com.miapp.controlpersonas_kotlin.updateperson.model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface UpdatePersonRepository {
    fun setPersonUpdateApi()
    fun setPersonUpdateDb(person : Persona?, context: Context) : Boolean?
}