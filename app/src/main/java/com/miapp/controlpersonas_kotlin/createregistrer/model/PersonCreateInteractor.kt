package com.miapp.controlpersonas_kotlin.createregistrer.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonCreateInteractor {
    fun setPersonCreateApi()
    fun setPersonCreateDb(person : Persona?, context: Context)
}