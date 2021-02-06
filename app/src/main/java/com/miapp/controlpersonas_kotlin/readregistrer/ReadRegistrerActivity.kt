package com.miapp.controlpersonas_kotlin.readregistrer

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
    private var rolProvitional : String = "PARTNER"
    private var editTextIdentification : EditText? = null
    private var editTextNames : EditText? = null
    private var editTextSurnames : EditText? = null
    private var editTextPhone : EditText? = null
    private var editTextTemperature : EditText? = null

    override fun onCreate(savedIntanceState: Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_read_registrer)
        //progressBar = findViewById<EditText>(R.id.progressbarReadRegistrer).text.toString()
        editTextIdentification = findViewById<EditText>(R.id.editTextConsultaIdentificacion)
        editTextNames = findViewById<EditText>(R.id.editTextConsultaNombres)
        editTextSurnames = findViewById<EditText>(R.id.editTextConsultaApellidos)
        editTextPhone = findViewById<EditText>(R.id.editTextConsultaTelefono)
        editTextTemperature  = findViewById<EditText>(R.id.editTextConsultaTemperatura)

        presenter = ReadRegistrerPresenter(this, ReadRegistrerInteractor(), this)
    }

    fun readRegistrer(view: View){
        var identification =  editTextIdentification?.text.toString().trim()
        var names = editTextNames?.text.toString().trim()
        var surnames = editTextSurnames?.text.toString().trim()
        var phone = editTextPhone?.text.toString().trim()
        var temperature = editTextTemperature?.text.toString().trim()
        presenter?.readRegistrer(identification, names, surnames, phone, temperature, rolProvitional)
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
        editTextIdentification?.setText(persona.getIdentificacion())
        editTextNames?.setText(persona.getNombres())
        editTextSurnames?.setText(persona.getApellidos())
        editTextPhone?.setText(persona.getTelefono())
        editTextTemperature ?.setText(persona.getTemperatura())
    }

    override fun setIdentificationEmptyError(){
        Toast.makeText(this, "Debes diligenciar el número de identificación", Toast.LENGTH_SHORT).show()
    }
}