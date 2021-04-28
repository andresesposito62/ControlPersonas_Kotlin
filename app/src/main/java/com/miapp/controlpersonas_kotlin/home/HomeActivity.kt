package com.miapp.controlpersonas_kotlin.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.miapp.controlpersonas_kotlin.R

class HomeActivity : AppCompatActivity() {

    private lateinit var spinner : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        spinner = findViewById<Spinner>(R.id.spinner_for_action_selection)
        val spinnerAdapter : ArrayAdapter<CharSequence> = ArrayAdapter
            .createFromResource(this, R.array.options_spinner, android.R.layout.simple_spinner_item)
        spinner.adapter = spinnerAdapter
    }
}