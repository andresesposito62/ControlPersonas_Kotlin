package com.miapp.controlpersonas_kotlin.vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.presentador.Instruccion
import com.miapp.controlpersonas_kotlin.presentador.Presentador

class SeleccionAccion : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_selector)
    }

    fun registrarPersona(view: View){
        var presentador = Presentador()
        var instruccion = Instruccion()
        instruccion.setTipoInstruccion("IMAGE_BUTTON_REGISTRAR_PERSONA_PRESIONADO")
        instruccion = presentador.solicitud(instruccion, this)!!
        if(instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            var intent = Intent(this, CreaRegistro::class.java)
            startActivity(intent)
        }
    }

    fun consultarPersona(view: View){
        var presentador = Presentador()
        var instruccion = Instruccion()
        instruccion.setTipoInstruccion("IMAGE_BUTTON_CONSULTAR_PERSONA_PRESIONADO")
        instruccion = presentador.solicitud(instruccion, this)!!
        if(instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            var intent = Intent(this, ConsultaRegistro::class.java)
            startActivity(intent)
        }
    }

    fun actualizarPersona(view: View){
        var presentador = Presentador()
        var instruccion = Instruccion()
        instruccion.setTipoInstruccion("IMAGE_BUTTON_ACTUALIZAR_PERSONA_PRESIONADO")
        instruccion = presentador.solicitud(instruccion, this)!!
        if(instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            var intent = Intent(this, ActualizaRegistro::class.java)
            startActivity(intent)
        }
    }

    fun eliminarPersona(view: View){
        var presentador = Presentador()
        var instruccion = Instruccion()
        instruccion.setTipoInstruccion("IMAGE_BUTTON_ELIMINAR_PERSONA_PRESIONADO")
        instruccion = presentador.solicitud(instruccion, this)!!
        if(instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            var intent = Intent(this, EliminaRegistro::class.java)
            startActivity(intent)
        }
    }

}