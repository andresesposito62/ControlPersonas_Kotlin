package com.miapp.controlpersonas_kotlin.updateregistrer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.miapp.controlpersonas_kotlin.databinding.ActivityPersonUpdateBinding
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.factory.MessageFactory
import com.miapp.controlpersonas_kotlin.factory.MessageFactory.Companion.TYPE_DATA_EMPTY
import com.miapp.controlpersonas_kotlin.factory.MessageFactory.Companion.TYPE_ERROR
import com.miapp.controlpersonas_kotlin.factory.MessageFactory.Companion.TYPE_SUCCESS
import com.miapp.controlpersonas_kotlin.updateregistrer.viewmodel.PersonUpdateViewModel

class PersonUpdateActivity : AppCompatActivity() {

    private lateinit var viewModel: PersonUpdateViewModel
    private var personUi: Persona? = Persona()
    private lateinit var binding : ActivityPersonUpdateBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPersonUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel?.getStatusQuery()?.observe(this, Observer<Boolean>{
            if(it){
                val messageFactory = MessageFactory()
                messageFactory.getMessage(this, TYPE_SUCCESS).show()
            }else{
                val messageFactory = MessageFactory()
                messageFactory.getMessage(this, TYPE_ERROR).show()
            }
        })

        viewModel?.getInitQuery()?.observe(this, Observer<Boolean>{
            if(it){
                if(binding.editTextActualizacionNombres.text.isNotEmpty()&&
                        binding.editTextActualizacionApellidos.text.isNotEmpty()&&
                        binding.editTextActualizacionIdentificacion.text.isNotEmpty()&&
                        binding.editTextActualizacionTelefono.text.isNotEmpty()&&
                        binding.editTextActualizacionTemperatura.text.isNotEmpty()){

                    personUi?.setIdentificacion(binding.editTextActualizacionIdentificacion.text.toString().trim())
                    personUi?.setNombres(binding.editTextActualizacionNombres.text.toString().trim())
                    personUi?.setApellidos(binding.editTextActualizacionApellidos.text.toString().trim())
                    personUi?.setTelefono(binding.editTextActualizacionTelefono.text.toString().trim())
                    personUi?.setTemperatura(binding.editTextActualizacionTemperatura.text.toString().trim())
                    personUi?.setRol("Partner")
                    //Toast.makeText(this, personUi.toString(), Toast.LENGTH_SHORT).show()
                    viewModel?.setPersonUpdate(personUi, this)
                }else{
                    val messageFactory = MessageFactory()
                    messageFactory.getMessage(this, TYPE_DATA_EMPTY).show()
                }
                viewModel.endQuery()
            }
        })
    }
}