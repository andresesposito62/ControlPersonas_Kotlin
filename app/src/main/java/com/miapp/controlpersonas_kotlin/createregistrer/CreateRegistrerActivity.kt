package com.miapp.controlpersonas_kotlin.createregistrer

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.readregistrer.ReadRegistrerInteractor
import com.miapp.controlpersonas_kotlin.readregistrer.ReadRegistrerPresenter

class CreateRegistrerActivity : AppCompatActivity(), CreateRegistrerPresenter.CreateRegistrerInterface{

    private var progressBar : ProgressBar? = null
    private var presenter : CreateRegistrerPresenter? = null
    private var rolProvitional : String = "PARTNER"
    private var editTextIdentification : EditText? = null
    private var editTextNames : EditText? = null
    private var editTextSurnames : EditText? = null
    private var editTextPhone : EditText? = null
    private var editTextTemperature : EditText? = null

    override fun onCreate(savedIntanceState: Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_create_registrer)
        progressBar = findViewById(R.id.progressBarCreateRegistrer)
        editTextIdentification = findViewById<EditText>(R.id.editTextRegistroIdentificacion)
        editTextNames = findViewById<EditText>(R.id.editTextRegistroNombres)
        editTextSurnames = findViewById<EditText>(R.id.editTextRegistroApellidos)
        editTextPhone = findViewById<EditText>(R.id.editTextRegistroTelefono)
        editTextTemperature  = findViewById<EditText>(R.id.editTextRegistroTemperatura)
        presenter = CreateRegistrerPresenter(this, CreateRegistrerInteractor(), this)
    }

    fun createRegistrer(view: View){
        var identification =  editTextIdentification?.text.toString().trim()
        var names = editTextNames?.text.toString().trim()
        var surnames = editTextSurnames?.text.toString().trim()
        var phone = editTextPhone?.text.toString().trim()
        var temperature = editTextTemperature?.text.toString().trim()
        presenter?.createRegistrer(identification, names, surnames, phone, temperature, rolProvitional)
    }

    override fun showProgress(){progressBar?.setVisibility(View.VISIBLE)}

    override fun hideProgress(){progressBar?.setVisibility(View.GONE)}

    override fun navigateToActionSelector() {
        TODO("Not yet implemented")
    }

    override fun setQueryError() {
        editTextIdentification?.setText("")
        editTextNames?.setText("")
        editTextSurnames?.setText("")
        editTextPhone?.setText("")
        editTextTemperature ?.setText("")
        Toast.makeText(this, "Error al crear el registro!", Toast.LENGTH_SHORT).show()
    }

    override fun setValuesEmptyError() {
        Toast.makeText(this, "Debes diligenciar todos los campos!", Toast.LENGTH_SHORT).show()
    }

    override fun setSucces() {
        editTextIdentification?.setText("")
        editTextNames?.setText("")
        editTextSurnames?.setText("")
        editTextPhone?.setText("")
        editTextTemperature ?.setText("")
        Toast.makeText(this, "Registro realizado exitosamente!", Toast.LENGTH_SHORT).show()
    }
}