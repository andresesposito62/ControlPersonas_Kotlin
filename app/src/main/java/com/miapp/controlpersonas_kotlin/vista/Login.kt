package com.miapp.controlpersonas_kotlin.vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.presentador.Instruccion
import com.miapp.controlpersonas_kotlin.presentador.Presentador


class Login: AppCompatActivity() {

    private var editTextUsuario : EditText? = null
    private var editTextPassword : EditText? = null

    override fun onCreate(savedIntanceState : Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_login)
        editTextUsuario = findViewById(R.id.editTextUsuario)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun iniciarSesion(view : View){
        var usuario : String = editTextUsuario?.text.toString()
        var password : String = editTextPassword?.text.toString()
        if (!usuario.isEmpty() && !password.isEmpty()) {
            val presentador = Presentador()
            var instruccion: Instruccion? = Instruccion()
            instruccion!!.setTipoInstruccion("BOTON_LOGIN_PRESIONADO")
            instruccion = presentador.solicitud(instruccion, this)
            if (instruccion!!.getTipoInstruccion().equals("CAMBIAR_PANTALLA")) {
                val intent = Intent(this, SeleccionAccion::class.java)
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Debes diligenciar todos los datos", Toast.LENGTH_SHORT).show()
        }
    }

}