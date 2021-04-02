package com.miapp.controlpersonas_kotlin.updateregistrer.model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonUpdateRepository {
    fun setPersonUpdateApi()
    fun setPersonUpdateDb(person : Persona?, context: Context) : MutableLiveData<Boolean>
}