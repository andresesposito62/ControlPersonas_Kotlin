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


class EliminaRegistro : AppCompatActivity() {
    var editTextIdentificacion : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elimina_registro)
        editTextIdentificacion = findViewById<EditText>(R.id.editTextIEliminacionIdentificacion)
    }

    fun eliminar(view: View?) {
        var identificacion = editTextIdentificacion?.text.toString().trim()
        if (identificacion != "") {
            var persona = Persona()
            persona.setIdentificacion(identificacion)
            var presentador = Presentador()
            presentador.Constructor(persona)
            var instruccion  = Instruccion()
            instruccion.setTipoInstruccion("BOTON_ELIMINAR_PERSONA_PRESIONADO")
            instruccion = presentador.solicitud(instruccion, this@EliminaRegistro)
            if (instruccion.getTipoInstruccion() == MOSTRAR_SOLICITUD_EXITOSA) {
                Toast.makeText(this, "Registro eliminado correctamente", Toast.LENGTH_SHORT).show()
                editTextIdentificacion!!.setText("")
            } else if (instruccion.getTipoInstruccion() == MOSTRAR_SOLICITUD_FALLIDA) {
                Toast.makeText(this, "No es posible eliminar el registro", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Debes diligenciar el número de identificación", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val MOSTRAR_SOLICITUD_EXITOSA = "MOSTRAR_SOLICITUD_EXITOSA"
        const val MOSTRAR_SOLICITUD_FALLIDA = "MOSTRAR_SOLICITUD_FALLIDA"
    }
}