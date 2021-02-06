package com.miapp.controlpersonas_kotlin.modelo.datos

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface InterfaceReadFromDataBase {
    fun readRegistrerFromDataBase(persona: Persona, context: Context): Persona
}