package com.miapp.controlpersonas_kotlin.login
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.actionselector.ActionSelectorActivity
import com.miapp.controlpersonas_kotlin.vista.SeleccionAccion

public class LoginActivity : AppCompatActivity(), LoginView {

    private var progressBar : ProgressBar? = null
    private var presenter : LoginPresenter? = null
    private var username : EditText? = null
    private var password : EditText? = null

    override fun onCreate(savedIntanceState : Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_login)

        progressBar = findViewById(R.id.progress)
        username = findViewById(R.id.editTextUsuario)
        password = findViewById(R.id.editTextPassword)
        findViewById<Button>(R.id.botonLogin).setOnClickListener({v: View? -> validateCredentials() })
        presenter = LoginPresenter(this, LoginInteractor())

    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }

    override fun showProgress(){progressBar?.setVisibility(View.VISIBLE)}

    override fun hideProgress(){progressBar?.setVisibility(View.GONE)}

    override fun setUsernameError(){username!!.setError("Nombre de usuario no puede estar vacio")}

    override fun setPasswordError(){password!!.setError("Nombre de usuario no puede estar vacio")}

    override fun navigateToHome(){
        val intent = Intent(this, ActionSelectorActivity::class.java)
        startActivity(intent)}

    private fun validateCredentials(){
        presenter?.validateCredentials(username?.text.toString(), password?.text.toString())
    }
}