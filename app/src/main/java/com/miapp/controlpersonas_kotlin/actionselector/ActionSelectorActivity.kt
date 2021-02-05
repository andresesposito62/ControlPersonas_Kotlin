package com.miapp.controlpersonas_kotlin.actionselector

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.readregistrer.ReadRegistrerActivity

class ActionSelectorActivity : AppCompatActivity(), ActionSelectorView{

    private var presenter : ActionSelectorPresenter? = null


    override fun onCreate(savedIntanceState: Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_action_selector)
        //rol = findViewById(R.id.editTextPassword)
        presenter = ActionSelectorPresenter(this)
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    fun createRegistrer(view: View){
        presenter?.createRegistrerPressed()
    }

    fun readRegistrer(view: View){
        presenter?.readRegistrerPressed()
    }

    fun updateRegistrer(view: View){
        presenter?.updateRegistrerPressed()
    }

    fun deleteRegistrer(view: View){
        presenter?.deleteRegistrerPressed()
    }


    override  fun navigateToHome(){
        Toast.makeText(this, "Navegando a Home", Toast.LENGTH_SHORT).show()
    }

    override fun navigateToCreateRegistrer(){
        val intent = Intent(this, ReadRegistrerActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToReadRegistrer(){
        val intent = Intent(this, ReadRegistrerActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToUpdateRegistrer(){
        val intent = Intent(this, ReadRegistrerActivity::class.java)
        startActivity(intent)
    }
    override fun navigateToDeleteRegistrer(){
        val intent = Intent(this, ReadRegistrerActivity::class.java)
        startActivity(intent)
    }

}