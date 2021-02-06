package com.miapp.controlpersonas_kotlin.modelo.domain

import java.lang.reflect.Constructor

class Persona  {


    private var identificacion : String? = null
    private var nombres : String? = null
    private var apellidos : String? = null
    private var telefono : String? = null
    private var temperatura : String? = null
    private var rol : String? = null

    fun Persona() {}

    fun constructor(identificacion: String?, nombres: String?, apellidos: String?,
                telefono: String?, temperatura: String?, rol: String?) {
        this.identificacion = identificacion
        this.nombres = nombres
        this.apellidos = apellidos
        this.telefono = telefono
        this.temperatura = temperatura
        this.rol = rol
    }
    fun getIdentificacion(): String? { return identificacion }

    fun setIdentificacion(identificacion: String?) { this.identificacion = identificacion }

    fun getNombres(): String? { return nombres }

    fun setNombres(nombres: String?) { this.nombres = nombres }

    fun getApellidos(): String? { return apellidos }

    fun setApellidos(apellidos: String?) { this.apellidos = apellidos }

    fun getTelefono(): String? { return telefono }

    fun setTelefono(telefono: String?) { this.telefono = telefono }

    fun getRol(): String? { return rol }

    fun setRol(rol: String?) { this.rol = rol }

    fun getTemperatura(): String? { return temperatura }

    fun setTemperatura(temperatura: String?) { this.temperatura = temperatura }

    override fun toString(): String {
        return "Persona(identificacion=$identificacion, nombres=$nombres, apellidos=$apellidos, telefono=$telefono, temperatura=$temperatura, rol=$rol)"
    }


}