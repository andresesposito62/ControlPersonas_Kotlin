package com.miapp.controlpersonas_kotlin.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.miapp.controlpersonas_kotlin.R

class HomeActivity : AppCompatActivity() {

    private lateinit var spinner : Spinner
    private lateinit var spinnerAdapter : ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpSpinner()
        spinnerListener()
    }

    private fun setUpSpinner() {
        spinner = findViewById<Spinner>(R.id.spinner_for_action_selection)
        spinnerAdapter  = ArrayAdapter.createFromResource(this, R.array.options_spinner,
                          android.R.layout.simple_spinner_item)
        spinner.adapter = spinnerAdapter
    }

    private fun spinnerListener(){
        spinner.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(parent?.context, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}