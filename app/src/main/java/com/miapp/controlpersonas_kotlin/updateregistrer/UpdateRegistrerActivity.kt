package com.miapp.controlpersonas_kotlin.updateregistrer

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.createregistrer.CreateRegistrerInteractor
import com.miapp.controlpersonas_kotlin.createregistrer.CreateRegistrerPresenter

class UpdateRegistrerActivity : AppCompatActivity(), UpdateRegistrerView{

    private var progressBar : ProgressBar? = null
    private var presenter : UpdateRegistrerPresenter? = null
    private var rolProvitional : String = "PARTNER"
    private var editTextIdentification : EditText? = null
    private var editTextNames : EditText? = null
    private var editTextSurnames : EditText? = null
    private var editTextPhone : EditText? = null
    private var editTextTemperature : EditText? = null

    override fun onCreate(savedIntanceState: Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_update_registrer)
        //progressBar = findViewById<EditText>(R.id.progressbarReadRegistrer).text.toString()
        editTextIdentification = findViewById<EditText>(R.id.editTextActualizacionIdentificacion)
        editTextNames = findViewById<EditText>(R.id.editTextActualizacionNombres)
        editTextSurnames = findViewById<EditText>(R.id.editTextActualizacionApellidos)
        editTextPhone = findViewById<EditText>(R.id.editTextActualizacionTelefono)
        editTextTemperature  = findViewById<EditText>(R.id.editTextActualizacionTemperatura)

        presenter = UpdateRegistrerPresenter(this, UpdateRegistrerInteractor(), this)
    }

    fun updateRegistrer(view: View){
        var identification =  editTextIdentification?.text.toString().trim()
        var names = editTextNames?.text.toString().trim()
        var surnames = editTextSurnames?.text.toString().trim()
        var phone = editTextPhone?.text.toString().trim()
        var temperature = editTextTemperature?.text.toString().trim()
        presenter?.updateRegistrer(identification, names, surnames, phone, temperature, rolProvitional)
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun navigateToActionSelector() {
        TODO("Not yet implemented")
    }

    override fun setQueryError() {
        Toast.makeText(this, "Error al actualizar el registro!", Toast.LENGTH_SHORT).show()
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
        Toast.makeText(this, "Registro actualizado exitosamente!", Toast.LENGTH_SHORT).show()
    }
}