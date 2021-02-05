package com.miapp.controlpersonas_kotlin.readregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.datos.PersonaDaoImplementacion
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ReadRegistrerInteractor {

    interface OnLoginFinishedListener{
        fun onIdentificationError()

        fun onSuccess(persona: Persona)
    }

    fun login(persona: Persona, listener: OnLoginFinishedListener, context: Context?){//, context: Context) {

        var personaDaoImplementacion = PersonaDaoImplementacion()
        var personaResult = personaDaoImplementacion.consultarPersona(persona, context!! )

        if(personaResult.getNombres() != "" && personaResult.getApellidos() != ""&& personaResult.getTelefono() != ""
                && personaResult.getTemperatura() != "" && personaResult.getRol() != ""){
            listener?.onSuccess(returnPerson(personaResult))

        }else{
            listener?.onIdentificationError()
        }
    }

    fun returnPerson(persona: Persona) : Persona{
        return persona
    }
}