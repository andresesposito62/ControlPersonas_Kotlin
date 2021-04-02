package com.miapp.controlpersonas_kotlin.updateregistrer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.updateregistrer.viewmodel.PersonUpdateViewModel

class PersonUpdateActivity : AppCompatActivity() {

    private var viewModel: PersonUpdateViewModel? = null
    var personUi: Persona? = Persona()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_update)
        viewModel = ViewModelProvider(this).get()
        observeViewModel()
        onButtonClick()
    }

    private fun observeViewModel() {
        viewModel?.getStatusQuery()?.observe(this, Observer<Boolean>{
            if(it){
                Toast.makeText(this, "Actualizacion de datos Exitosa", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Error en la actualizacion", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun onButtonClick() {
        findViewById<Button>(R.id.botonActualizar).setOnClickListener {
            personUi?.setIdentificacion(findViewById<EditText>(R.id.editTextActualizacionIdentificacion).text.toString().trim())
            personUi?.setNombres(findViewById<EditText>(R.id.editTextActualizacionNombres).text.toString().trim())
            personUi?.setApellidos(findViewById<EditText>(R.id.editTextActualizacionApellidos).text.toString().trim())
            personUi?.setTelefono(findViewById<EditText>(R.id.editTextActualizacionTelefono).text.toString().trim())
            personUi?.setTemperatura(findViewById<EditText>(R.id.editTextActualizacionTemperatura).text.toString().trim())
            personUi?.setRol("Partner")
            viewModel?.setPersonUpdate(personUi, this)
        }
    }
}