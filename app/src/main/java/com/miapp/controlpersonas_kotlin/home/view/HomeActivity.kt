package com.miapp.controlpersonas_kotlin.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.databinding.ActivityHomeBinding
import com.miapp.controlpersonas_kotlin.singleton.SpinnerActionSingletonObservable
import com.miapp.controlpersonas_kotlin.home.viewmodel.HomeActivityViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var spinner : Spinner
    private lateinit var spinnerAdapter : ArrayAdapter<CharSequence>
    private lateinit var viewModel: HomeActivityViewModel
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get()
        //binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setUpSpinner()
        spinnerListener()
    }

    private fun setUpSpinner() {
        spinner = binding.spinnerForActionSelection
        spinnerAdapter  = ArrayAdapter.createFromResource(this, R.array.options_spinner,
                          android.R.layout.simple_spinner_item)
        spinner.adapter = spinnerAdapter
    }

    private fun spinnerListener(){
        spinner.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SpinnerActionSingletonObservable.getInstance(this@HomeActivity)
                    .setPositionSpinnerActionSelector(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}