package com.miapp.controlpersonas_kotlin.deleteperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface DeletePersonRepository {
    fun setDeletePersonApi()
    fun setDeletePersonDB(person: Persona?, context: Context): Boolean?
}