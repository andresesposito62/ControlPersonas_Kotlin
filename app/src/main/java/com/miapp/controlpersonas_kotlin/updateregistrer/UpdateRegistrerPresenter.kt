package com.miapp.controlpersonas_kotlin.updateregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.createregistrer.CreateRegistrerInteractor
import com.miapp.controlpersonas_kotlin.createregistrer.CreateRegistrerView
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class UpdateRegistrerPresenter : UpdateRegistrerInteractor.OnLoginFinishedListener{
    private var updateRegistrerView : UpdateRegistrerView? = null
    private var updateRegistrerInteractor : UpdateRegistrerInteractor//? = null
    private var context : Context
    private var person = Persona()


    constructor(updateRegistrerView: UpdateRegistrerView, updateRegistrerInteractor: UpdateRegistrerInteractor, context: Context){
        this.updateRegistrerView = updateRegistrerView
        this.updateRegistrerInteractor = updateRegistrerInteractor
        this.context = context
    }

    fun updateRegistrer(identification : String, names : String, surnames : String, phone: String,
                        temperature : String, rol : String ){
        if(updateRegistrerView != null){
            //  readRegistrerView?.showProgress()
        }

        if(identification != "" && names != "" && surnames != "" && phone != "" && temperature != "" && rol != ""){
            person.setIdentificacion(identification)
            person.setNombres(names)
            person.setTelefono(phone)
            person.setApellidos(surnames)
            person.setTemperatura(temperature)
            person.setRol(rol)
            updateRegistrerInteractor.queryToDataBase(person,this, context)
        }else{
            setEmptyValuesError()
        }
    }

    override fun onCreateRegistrerError() {
       updateRegistrerView!!.setQueryError()
    }

    override fun onSuccess() {
        updateRegistrerView!!.setSucces()
    }

    fun setEmptyValuesError(){
        updateRegistrerView!!.setValuesEmptyError()
    }
}