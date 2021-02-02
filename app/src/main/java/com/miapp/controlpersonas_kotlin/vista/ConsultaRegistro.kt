package com.miapp.controlpersonas_kotlin.vista

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.modelo.datos.PersonaDaoImplementacion
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.presentador.Instruccion
import com.miapp.controlpersonas_kotlin.presentador.Presentador


class ConsultaRegistro : AppCompatActivity() {
    private val MOSTRAR_SOLICITUD_EXITOSA : String = "MOSTRAR_SOLICITUD_EXITOSA"
    private val MOSTRAR_SOLICITUD_FALLIDA : String = "MOSTRAR_SOLICITUD_FALLIDA"
    private var editTextIdentificacion : EditText? = null
    private var editTextNombres : EditText? = null
    private var editTextApellidos : EditText? = null
    private var editTextTelefono : EditText? = null
    private var editTextTemperatura : EditText? = null
    private var rol : String  = "PARTNER"

    protected override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_registro)
        editTextIdentificacion = findViewById<EditText>(R.id.editTextConsultaIdentificacion)
        editTextNombres = findViewById<EditText>(R.id.editTextConsultaNombres)
        editTextApellidos = findViewById<EditText>(R.id.editTextConsultaApellidos)
        editTextTelefono = findViewById<EditText>(R.id.editTextConsultaTelefono)
        editTextTemperatura = findViewById<EditText>(R.id.editTextConsultaTemperatura)
    }

    fun consultar(view : View){
        var identificacion =  editTextIdentificacion?.text.toString().trim()
        if( identificacion != "" ){
            var persona = Persona()
            persona.setIdentificacion(identificacion)
            var presentador = Presentador()
            presentador.Constructor(persona)
            var instruccion = Instruccion()
            instruccion.setTipoInstruccion("BOTON_CONSULTAR_PERSONA_PRESIONADO")
            instruccion = presentador.solicitud(instruccion, this@ConsultaRegistro)!!
            if(instruccion.getTipoInstruccion() == MOSTRAR_SOLICITUD_EXITOSA){
                persona = instruccion.obtenerObjetoPersona()
                editTextIdentificacion!!.setText(persona.getIdentificacion())
                editTextNombres!!.setText(persona.getNombres())
                editTextApellidos!!.setText(persona.getApellidos())
                editTextTelefono!!.setText(persona.getTelefono())
                editTextTemperatura!!.setText(persona.getTemperatura())
            } else if (instruccion.getTipoInstruccion() == MOSTRAR_SOLICITUD_FALLIDA) {
                Toast.makeText(this, "No es posible consultar el registro", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Debes diligenciar el número de identificación", Toast.LENGTH_SHORT).show()
        }
    }
}