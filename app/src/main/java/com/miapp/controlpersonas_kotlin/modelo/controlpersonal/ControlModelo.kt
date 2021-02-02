package com.miapp.controlpersonas_kotlin.modelo.controlpersonal

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.datos.PersonaDaoImplementacion
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona


class ControlModelo {
    private var identificacion: String = ""
    private var nombres: String = ""
    private var apellidos: String = ""
    private var telefono: String = ""
    private var temperatura: String = ""
    private var rol: String = ""

    fun ControlModelo() {}

    constructor(persona: Persona) {
        identificacion = persona.getIdentificacion().toString()
        nombres = persona.getNombres().toString()
        apellidos = persona.getApellidos().toString()
        telefono = persona.getTelefono().toString()
        temperatura = persona.getTemperatura().toString()
        rol = persona.getRol().toString()
    }

    fun SolicitudBaseDeDatos(solicitud: String, context: Context): Persona {

        //InterfazPersonaDao personaDao = new PersonaDaoImplementacion();
        var personaDao = PersonaDaoImplementacion()
        var persona: Persona = Persona()
        persona.Constructor(identificacion, nombres, apellidos, telefono, temperatura, rol)
        if (solicitud == SOLICITUD_REGISTRAR) {
            val registrosAfectados = personaDao.registrarPersona(persona, context)
            persona.setIdentificacion(registrosAfectados.toString())
        } else if (solicitud == SOLICITUD_ACTUALIZAR) {
            val registrosAfectados = personaDao.actualizarPersona(persona, context)
            persona.setIdentificacion(registrosAfectados.toString())
        } else if (solicitud == SOLICITUD_ELIMINAR) {
            val registrosAfectados = personaDao.eliminarPersona(persona, context)
            if (registrosAfectados != -1L) {
                //Registro Exitoso
                persona.setIdentificacion("Registro eliminado exitosamente")
            } else {
                //Registro NO Exitoso
                persona.setIdentificacion("Registro no eliminado")
            }
        } else if (solicitud == SOLICITUD_CONSULTAR) {
            persona = personaDao.consultarPersona(persona, context)
        }
        return persona
    }

    companion object {
        const val SOLICITUD_REGISTRAR = "REGISTRAR"
        const val SOLICITUD_ACTUALIZAR = "ACTUALIZAR"
        const val SOLICITUD_CONSULTAR = "CONSULTAR"
        const val SOLICITUD_ELIMINAR = "ELIMINAR"
        const val SOLICITUD_EXITOSA = "SOLICITUD_EXITOSA"
        const val SOLICITUD_FALLIDA = "SOLICITUD_FALLIDA"
    }
}