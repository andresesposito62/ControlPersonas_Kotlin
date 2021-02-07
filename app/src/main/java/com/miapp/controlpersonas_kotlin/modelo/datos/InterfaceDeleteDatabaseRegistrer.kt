package com.miapp.controlpersonas_kotlin.modelo.datos

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface InterfaceDeleteDatabaseRegistrer {
    fun eliminarPersona(persona: Persona, context: Context): Long
}