package com.miapp.controlpersonas_kotlin.personread.view

import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

interface PersonReadView {
    fun getPersonRead(person: Persona?)
    fun showPersonRead()
    fun setQueryError()
    fun setIdentificationError()
}