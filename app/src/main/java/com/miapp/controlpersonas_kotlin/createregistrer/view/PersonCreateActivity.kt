package com.miapp.controlpersonas_kotlin.createregistrer.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.createregistrer.presenter.PersonCreatePresenter
import com.miapp.controlpersonas_kotlin.createregistrer.presenter.PersonCreatePresenterImpl
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class PersonCreateActivity : AppCompatActivity(), PersonCreateView {

    private var personCreatePresenter : PersonCreatePresenter? = null
    private var personUi = Persona()
    private var rolProvitional : String = "PARTNER"
    private var editTextIdentification : EditText? = null
    private var editTextNames : EditText? = null
    private var editTextSurnames : EditText? = null
    private var editTextPhone : EditText? = null
    private var editTextTemperature : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_create)
        editTextIdentification = findViewById<EditText>(R.id.editTextRegistroIdentificacion)
        editTextNames = findViewById<EditText>(R.id.editTextRegistroNombres)
        editTextSurnames = findViewById<EditText>(R.id.editTextRegistroApellidos)
        editTextPhone = findViewById<EditText>(R.id.editTextRegistroTelefono)
        editTextTemperature  = findViewById<EditText>(R.id.editTextRegistroTemperatura)

        personCreatePresenter = PersonCreatePresenterImpl(this)

        findViewById<Button>(R.id.botonRegistrar).setOnClickListener {
            personUi.setIdentificacion(editTextIdentification?.text.toString().trim())
            personUi.setNombres(editTextNames?.text.toString().trim())
            personUi.setApellidos(editTextSurnames?.text.toString().trim())
            personUi.setTelefono(editTextPhone?.text.toString().trim())
            personUi.setTemperatura(editTextTemperature?.text.toString().trim())
            personUi.setRol(rolProvitional.trim())
            setPersonCreate(personUi, this)
        }
    }

    override fun setPersonCreate(person: Persona?, context: Context) {
        personCreatePresenter?.setPersonCreate(person, context)
    }

    override fun showResultSuccess() {
        editTextIdentification?.setText("")
        editTextNames?.setText("")
        editTextSurnames?.setText("")
        editTextPhone?.setText("")
        editTextTemperature ?.setText("")
        Toast.makeText(this, "Registro realizado exitosamente!", Toast.LENGTH_SHORT).show()
    }

    override fun showQueryError() {
        editTextIdentification?.setText("")
        editTextNames?.setText("")
        editTextSurnames?.setText("")
        editTextPhone?.setText("")
        editTextTemperature ?.setText("")
        Toast.makeText(this, "Error al crear el registro!", Toast.LENGTH_SHORT).show()
    }

    override fun showDataInputError() {
        Toast.makeText(this, "Debes diligenciar todos los campos!", Toast.LENGTH_SHORT).show()
    }
}