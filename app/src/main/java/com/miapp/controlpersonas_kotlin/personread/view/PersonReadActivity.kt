package com.miapp.controlpersonas_kotlin.personread.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.presenter.PersonReadPresenter
import com.miapp.controlpersonas_kotlin.personread.presenter.PersonReadPresenterImpl

class PersonReadActivity : AppCompatActivity(), PersonReadView {

    private var personReadPresenter : PersonReadPresenter? = null
    private var personUi = Persona()
    private var rolProvitional : String = "PARTNER"
    private var editTextIdentification : EditText? = null
    private var editTextNames : EditText? = null
    private var editTextSurnames : EditText? = null
    private var editTextPhone : EditText? = null
    private var editTextTemperature : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_read)

        editTextIdentification = findViewById<EditText>(R.id.editTextConsultaIdentificacion)
        editTextNames = findViewById(R.id.editTextConsultaNombres)
        editTextSurnames = findViewById(R.id.editTextConsultaApellidos)
        editTextPhone = findViewById(R.id.editTextConsultaTelefono)
        editTextTemperature  = findViewById(R.id.editTextConsultaTemperatura)

        findViewById<Button>(R.id.botonConsultar).setOnClickListener {
            var identification : String =  editTextIdentification?.text.toString().trim()
            personUi.setIdentificacion(identification)
            getPersonRead(personUi)
        }
        personReadPresenter = PersonReadPresenterImpl(this)

        showPersonRead()
    }


    override fun getPersonRead(person: Persona?) {
        personReadPresenter?.getPersonRead(personUi, this)
    }

    override fun showPersonRead() {
        personReadPresenter?.getPersonReadLiveData()?.observe(this, Observer<Persona?>{
            editTextIdentification?.setText(it?.getIdentificacion().toString())
            editTextNames?.setText(it?.getNombres().toString())
            editTextSurnames?.setText(it?.getApellidos().toString())
            editTextPhone?.setText(it?.getTelefono().toString())
            editTextTemperature?.setText(it?.getTemperatura().toString())
        })

    }

    override fun setQueryError() {
        Toast.makeText(this, "Error en la consulta", Toast.LENGTH_SHORT).show()
    }

    override fun setIdentificationError() {
        Toast.makeText(this, "Debes diligenciar el número de identificación", Toast.LENGTH_SHORT).show()
    }
}