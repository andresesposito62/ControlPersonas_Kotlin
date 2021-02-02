package com.miapp.controlpersonas_kotlin.presentador

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.persistableBundleOf
import com.miapp.controlpersonas_kotlin.modelo.datos.PersonaDaoImplementacion
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.vista.*


class Presentador : AppCompatActivity(){

    private val MOSTRAR_SOLICITUD_EXITOSA : String = "MOSTRAR_SOLICITUD_EXITOSA"
    private val MOSTRAR_SOLICITUD_FALLIDA : String = "MOSTRAR_SOLICITUD_FALLIDA"
    private var persona = Persona()

    fun Presentador(){}

    fun Constructor(persona : Persona){ this.persona = persona }

    fun solicitud(instruccion: Instruccion, context: Context): Instruccion{

        if(instruccion.getTipoInstruccion() == "BOTON_LOGIN_PRESIONADO"){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA")
        }else if(instruccion.getTipoInstruccion() == "IMAGE_BUTTON_REGISTRAR_PERSONA_PRESIONADO"){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA")
        }else if(instruccion.getTipoInstruccion() == "BOTON_REGISTRAR_PERSONA_PRESIONADO"){
            var personaDaoImplementacion = PersonaDaoImplementacion()
            var resultadoInstruccion : Long? = personaDaoImplementacion.registrarPersona(persona, context)
            if (resultadoInstruccion != -1L){
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA)
            }else{
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA)
            }
        }else if(instruccion.getTipoInstruccion() == "IMAGE_BUTTON_CONSULTAR_PERSONA_PRESIONADO"){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA")
        }else if(instruccion.getTipoInstruccion() == "BOTON_CONSULTAR_PERSONA_PRESIONADO"){
            var personaDaoImplementacion = PersonaDaoImplementacion()
            persona = personaDaoImplementacion.consultarPersona(persona, context)
            if(persona.getIdentificacion() != ""){
                instruccion?.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA)
                instruccion?.recibirObjetoPersona(persona)
            }else{
                instruccion?.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA)
            }
        }else if(instruccion?.getTipoInstruccion() == "IMAGE_BUTTON_ELIMINAR_PERSONA_PRESIONADO"){
            instruccion?.setTipoInstruccion("CAMBIAR_PANTALLA")
        }else if(instruccion?.getTipoInstruccion() == "BOTON_ELIMINAR_PERSONA_PRESIONADO"){
            var personaDaoImplementacion = PersonaDaoImplementacion()
            var resultadoInstruccion : Long? = personaDaoImplementacion.eliminarPersona(persona, context)
            if(resultadoInstruccion != -1L){
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA)
            }else{
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA)
            }
        }else if(instruccion.getTipoInstruccion() == "IMAGE_BUTTON_ACTUALIZAR_PERSONA_PRESIONADO"){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA")
        }else if(instruccion.getTipoInstruccion() == "BOTON_ACTUALIZAR_PERSONA_PRESIONADO"){
            var personaDaoImplementacion = PersonaDaoImplementacion()
            var resultadoInstruccion : Long? = personaDaoImplementacion.actualizarPersona(persona, context)
            if(resultadoInstruccion != -1L){
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA)
            }else{
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA)
            }
        }
        return instruccion
    }
}