package com.miapp.controlpersonas_kotlin.home.readperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonReadRepository {
    fun getPersonReadApi()
    fun getPersonReadDB(person: Persona?, context: Context)
}