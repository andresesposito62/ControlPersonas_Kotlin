package com.miapp.controlpersonas_kotlin.personread.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonReadRepository {
    fun getPersonReadApi()
    fun getPersonReadDB(person: Persona?, context: Context)
}