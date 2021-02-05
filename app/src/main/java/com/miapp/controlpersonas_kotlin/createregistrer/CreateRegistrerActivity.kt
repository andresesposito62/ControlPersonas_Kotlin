package com.miapp.controlpersonas_kotlin.createregistrer

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R

class CreateRegistrerActivity : AppCompatActivity(), CreateRegistrerView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_registrer)
    }

    fun createRegistrer(view: View){

    }

    override fun setidentificationError() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun setNamesError() {
        TODO("Not yet implemented")
    }

    override fun setSurnamesError() {
        TODO("Not yet implemented")
    }

    override fun setPhoneError() {
        TODO("Not yet implemented")
    }

    override fun setTemperatureError() {
        TODO("Not yet implemented")
    }

    override fun navigateToActionSelector() {
        TODO("Not yet implemented")
    }
}