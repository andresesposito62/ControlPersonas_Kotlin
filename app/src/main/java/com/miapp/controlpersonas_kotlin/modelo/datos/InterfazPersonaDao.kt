package com.miapp.controlpersonas_kotlin.modelo.datos

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona


interface InterfazPersonaDao {
    fun registrarPersona(persona: Persona, context: Context): Long
    fun actualizarPersona(persona: Persona, context: Context): Long
    fun eliminarPersona(persona: Persona, context: Context): Long
    fun consultarPersona(persona: Persona, context: Context): Persona
}