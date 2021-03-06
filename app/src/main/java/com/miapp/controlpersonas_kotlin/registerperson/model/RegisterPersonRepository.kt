package com.miapp.controlpersonas_kotlin.registerperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface RegisterPersonRepository {
    fun setRegisterPersonApi()
    fun setRegisterPersonDB(person : Persona?, context: Context): Long?
    suspend fun setRegisterPersonDbRoom(person : Persona?, context: Context): Long?
}