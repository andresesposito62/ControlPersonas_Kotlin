package com.miapp.controlpersonas_kotlin.actionselector

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.readregistrer.ReadRegistrerActivity

class ActionSelectorActivity : AppCompatActivity(), ActionSelectorView{

    private var presenter : ActionSelectorPresenter? = null

    override fun onCreate(savedIntanceState : Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_action_selector)

        //progressBar = findViewById(R.id.progressActionSelector)
        //findViewById<Button>(R.id.botonConsultar).setOnClickListener({ v: View? -> chooseActivity("READ_REGISTRER") })
        //presenter =ActionSelectorPresenter(this, ActionSelectorInteractor())

    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }

    override fun navigateToHome(){
        val intent = Intent(this, ActionSelectorActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToReadRegistrer() {
        val intent = Intent(this, ReadRegistrerActivity::class.java)
        startActivity(intent)
    }

    private fun chooseActivity(string : String){
        presenter?.chooseActivity(string)
    }
}