package com.miapp.controlpersonas_kotlin.readregistrer

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.login.LoginInteractor
import com.miapp.controlpersonas_kotlin.login.LoginPresenter

class ReadRegistrerActivity : AppCompatActivity() {
    override fun onCreate(savedIntanceState : Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_read_registrer)

    }
}