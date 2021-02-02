package com.miapp.controlpersonas_kotlin.vista

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.presentador.Instruccion
import com.miapp.controlpersonas_kotlin.presentador.Presentador

class ActualizaRegistro : AppCompatActivity() {
    private val MOSTRAR_SOLICITUD_EXITOSA : String? = "MOSTRAR_SOLICITUD_EXITOSA"
    private val MOSTRAR_SOLICITUD_FALLIDA : String? = "MOSTRAR_SOLICITUD_FALLIDA"
    private var editTextIdentificacion : EditText? = null
    private var editTextNombres : EditText? = null
    private var editTextApellidos : EditText? = null
    private var editTextTelefono : EditText? = null
    private var editTextTemperatura : EditText? = null
    private var rol : String  = "PARTNER"

    protected override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualiza_registro)
        editTextIdentificacion =findViewById<EditText>(R.id.editTextActualizacionIdentificacion)
        editTextNombres =findViewById<EditText>(R.id.editTextActualizacionNombres)
        editTextApellidos =findViewById<EditText>(R.id.editTextActualizacionApellidos)
        editTextTelefono =findViewById<EditText>(R.id.editTextActualizacionTelefono)
        editTextTemperatura =findViewById<EditText>(R.id.editTextActualizacionTemperatura)
    }

    fun actualizar(view: View){
        var identificacion = editTextIdentificacion?.text.toString().trim()
        var nombres = editTextNombres?.text.toString().trim()
        var apellidos = editTextApellidos?.text.toString().trim()
        var telefono = editTextTelefono?.text.toString().trim()
        var temperatura = editTextTemperatura?.text.toString().trim()

        if(identificacion != "" && nombres != "" && apellidos != "" && telefono != ""  && temperatura != "" && rol != ""){
            var persona = Persona()
            persona.Constructor(identificacion, nombres, apellidos, telefono, temperatura, rol)
            //var persona = Persona(identificacion?, nombres?, apellidos?, telefono?, temperatura?, rol?)
            var presentador = Presentador()
            presentador.Constructor(persona)
            var instruccion = Instruccion()
            instruccion.setTipoInstruccion("BOTON_ACTUALIZAR_PERSONA_PRESIONADO")
            instruccion = presentador.solicitud(instruccion, this@ActualizaRegistro)!!
            if(instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_EXITOSA)){
                Toast.makeText(this, "Registro actualizado correctamente", Toast.LENGTH_SHORT).show()
                editTextIdentificacion?.setText("")
                editTextNombres?.setText("")
                editTextApellidos?.setText("")
                editTextTelefono?.setText("")
                editTextTemperatura?.setText("")
            }else if(instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_FALLIDA)){
                Toast.makeText(this, "No es posible actualizar el registro", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Debes diligenciar todos los datos", Toast.LENGTH_SHORT).show()
        }
    }
}