package com.miapp.controlpersonas_kotlin.createregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class CreateRegistrerPresenter : CreateRegistrerInteractor.OnLoginFinishedListener {
    private var createRegistrerView : CreateRegistrerView? = null
    private var createRegistrerInteractor : CreateRegistrerInteractor//? = null
    private var context : Context
    private var person = Persona()


    constructor(createRegistrerView: CreateRegistrerView, createRegistrerInteractor: CreateRegistrerInteractor, context: Context){
        this.createRegistrerView = createRegistrerView
        this.createRegistrerInteractor = createRegistrerInteractor
        this.context = context
    }

    fun createRegistrer(identification : String, names : String, surnames : String, phone: String,
                      temperature : String, rol : String ){
        if(createRegistrerView != null){
            //  readRegistrerView?.showProgress()
        }

        if(identification != "" && names != "" && surnames != "" && phone != "" && temperature != "" && rol != ""){
            person.setIdentificacion(identification)
            person.setNombres(names)
            person.setTelefono(phone)
            person.setApellidos(surnames)
            person.setTemperatura(temperature)
            person.setRol(rol)
            createRegistrerInteractor.queryToDataBase(person,this, context)
        }else{
            setEmptyValuesError()
        }
    }

    override fun onCreateRegistrerError() {
        createRegistrerView!!.setQueryError()
    }

    override fun onSuccess() {
        createRegistrerView!!.setSucces()
    }

    fun setEmptyValuesError(){
       createRegistrerView!!.setValuesEmptyError()
    }


}