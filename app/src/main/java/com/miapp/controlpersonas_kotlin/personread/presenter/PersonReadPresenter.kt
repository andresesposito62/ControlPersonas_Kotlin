package com.miapp.controlpersonas_kotlin.personread.presenter

import android.content.Context
import androidx.lifecycle.LiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonReadPresenter {
    fun showPersonRead(person : Persona?)
    fun getPersonRead(person : Persona?,context: Context)
    fun getPersonReadLiveData():LiveData<Persona?>
}