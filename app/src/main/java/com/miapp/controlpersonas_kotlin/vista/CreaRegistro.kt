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


class CreaRegistro : AppCompatActivity() {
    var editTextIdentificacion : EditText? = null
    var editTextNombres: EditText? = null
    var editTextApellidos: EditText? = null
    var editTextTelefono: EditText? = null
    var editTextTemperatura : EditText? = null
    var rol = "PARTNER"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea_registro)
        editTextIdentificacion = findViewById<View>(R.id.editTextRegistroIdentificacion) as EditText
        editTextNombres = findViewById<View>(R.id.editTextRegistroNombres) as EditText
        editTextApellidos = findViewById<View>(R.id.editTextRegistroApellidos) as EditText
        editTextTelefono = findViewById<View>(R.id.editTextRegistroTelefono) as EditText
        editTextTemperatura = findViewById<View>(R.id.editTextRegistroTemperatura) as EditText
    }

    fun registrar(view: View?) {
        var identificacion : String = editTextIdentificacion?.text.toString().trim()
        var nombres : String = editTextNombres?.text.toString().trim()
        var apellidos : String = editTextApellidos?.text.toString().trim()
        var telefono : String = editTextTelefono?.text.toString().trim()
        var temperatura : String = editTextTemperatura?.text.toString().trim()
        if (identificacion != "" && nombres != "" && apellidos != "" && telefono != "" && temperatura != "" && rol != "") {
            var persona = Persona()
            persona.Constructor(identificacion, nombres, apellidos, telefono, temperatura, rol)
            var presentador = Presentador()
            presentador.Constructor(persona)
            var instruccion: Instruccion = Instruccion()
            instruccion.setTipoInstruccion("BOTON_REGISTRAR_PERSONA_PRESIONADO")
            instruccion = presentador.solicitud(instruccion, this@CreaRegistro)
            if (instruccion.getTipoInstruccion() == MOSTRAR_SOLICITUD_EXITOSA) {
                Toast.makeText(this, "Registro exitoso!", Toast.LENGTH_SHORT).show()
                editTextIdentificacion!!.setText("")
                editTextNombres!!.setText("")
                editTextApellidos!!.setText("")
                editTextTelefono!!.setText("")
                editTextTemperatura!!.setText("")
            } else if (instruccion.getTipoInstruccion() == MOSTRAR_SOLICITUD_FALLIDA) {
                Toast.makeText(this, "No es posible realizar el registro", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Debes diligenciar todos los datos", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val MOSTRAR_SOLICITUD_EXITOSA = "MOSTRAR_SOLICITUD_EXITOSA"
        const val MOSTRAR_SOLICITUD_FALLIDA = "MOSTRAR_SOLICITUD_FALLIDA"
    }
}