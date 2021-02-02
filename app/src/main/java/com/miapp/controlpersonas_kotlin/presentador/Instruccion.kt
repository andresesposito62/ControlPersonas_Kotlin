package com.miapp.controlpersonas_kotlin.presentador

import com.miapp.controlpersonas_kotlin.modelo.domain.Persona


class Instruccion {

    private var tipoInstruccion: String = ""
    //private var claseSiguente: Class<*>? = null
    private var persona = Persona()

    fun Instruccion() {}

    fun Instruccion(tipoInstruccion: String) {
        this.tipoInstruccion = tipoInstruccion
    }

    fun recibirObjetoPersona(persona: Persona): Persona {
        this.persona = persona
        return persona
    }

    fun obtenerObjetoPersona(): Persona { return this.persona }

    fun getTipoInstruccion() : String{ return tipoInstruccion}

    fun setTipoInstruccion(tipoInstruccion : String){ this.tipoInstruccion = tipoInstruccion }

    /*fun getClaseSiguente(): Class<*>? { return claseSiguente }

    fun setClaseSiguiente(claseSiguiente : Class<*>?){this.claseSiguente = claseSiguente }*/

}