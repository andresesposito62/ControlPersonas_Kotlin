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
import com.miapp.controlpersonas_kotlin.updateregistrer.viewmodel.PersonUpdateViewModel

class PersonUpdateActivity : AppCompatActivity() {

    private var viewModel: PersonUpdateViewModel? = null
    var mockStatusQuery = false

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
                Toast.makeText(this, "Consulta Exitosa", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Error en la consulta", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun onButtonClick() {
        findViewById<Button>(R.id.botonActualizar).setOnClickListener {
            //viewModel.
            if(mockStatusQuery){
                viewModel?.querySuccess()
                mockStatusQuery = false
            }else{
                viewModel?.queryFailed()
                mockStatusQuery = true
            }
        }
    }
}