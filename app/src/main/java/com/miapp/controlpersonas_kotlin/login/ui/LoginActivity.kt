package com.miapp.controlpersonas_kotlin.login.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.databinding.ActivityLoginBinding
import com.miapp.controlpersonas_kotlin.login.LoginPresenter
import com.miapp.controlpersonas_kotlin.login.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel  : LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        //Se crea el observer
        val progressVisibilityObserver = Observer<Boolean>{
            //Lo que este aca se ejecuta cada vez que hay un cambio en nuestro objeto livedata
             //lo que se va arecibir es un it
            if(it == true){
                binding.progress.visibility = View.VISIBLE
            }else{
                binding.progress.visibility = View.GONE
            }
        }
        //Subscripcion
        viewModel.getProgressVisibility().observe(this@LoginActivity, progressVisibilityObserver)
    }

}