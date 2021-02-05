package com.miapp.controlpersonas_kotlin.readregistrer

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ReadRegistrerActivity : AppCompatActivity(), ReadRegistrerView {

    private var progressBar : ProgressBar? = null
    private var presenter : ReadRegistrerPresenter? = null
    private var identification : EditText? = null
    private var names : EditText? = null
    private var surnames : EditText? = null
    private var phone : EditText? = null
    private var temperature : EditText? = null
    private var rol : EditText? = null
    private var rolProvitional : String = "PARTNER"

    override fun onCreate(savedIntanceState: Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_read_registrer)
        progressBar = findViewById(R.id.progressbarReadRegistrer)
        identification = findViewById(R.id.editTextConsultaIdentificacion)
        names = findViewById(R.id.editTextConsultaNombres)
        surnames = findViewById(R.id.editTextConsultaApellidos)
        phone = findViewById(R.id.editTextConsultaTelefono)
        temperature = findViewById(R.id.editTextConsultaTemperatura)
        presenter = ReadRegistrerPresenter(this, ReadRegistrerInteractor(), this)
    }

    fun readRegistrer(view: View){

        presenter?.readRegistrer(identification.toString().trim(), names.toString().trim(), surnames.toString().trim(),
                                phone.toString().trim(), temperature.toString().trim(), rolProvitional)
    }


    override fun showProgress() {
        Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show()
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun setidentificationError() {
        TODO("Not yet implemented")
    }

    override fun navigateToActionSelector() {
        TODO("Not yet implemented")
    }

    override fun setQueryError() {
        Toast.makeText(this, "Error en la consulta", Toast.LENGTH_SHORT).show()
    }

    override fun setDates(persona: Persona) {
        identification!!.setText(persona.getIdentificacion())
        names!!.setText(persona.getNombres())
        surnames!!.setText(persona.getApellidos())
        phone!!.setText(persona.getTelefono())
        temperature!!.setText(persona.getTemperatura())
    }
}