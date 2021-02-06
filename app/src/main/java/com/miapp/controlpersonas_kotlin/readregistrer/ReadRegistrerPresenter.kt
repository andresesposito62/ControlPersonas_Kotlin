package com.miapp.controlpersonas_kotlin.readregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ReadRegistrerPresenter : ReadRegistrerInteractor.OnLoginFinishedListener {

    private var readRegistrerView : ReadRegistrerView? = null
    private var readRegistrerInteractor : ReadRegistrerInteractor//? = null
    private var context : Context
    private var person = Persona()


    constructor(readRegistrerView: ReadRegistrerView, readRegistrerInteractor: ReadRegistrerInteractor, context: Context){
        this.readRegistrerView = readRegistrerView
        this.readRegistrerInteractor = readRegistrerInteractor
        this.context = context
    }


    fun readRegistrer(identification : String, names : String, surnames : String, phone: String,
                      temperature : String, rol : String ){
        if(readRegistrerView != null){
          //  readRegistrerView?.showProgress()
        }

        if(identification != ""){
            person.setIdentificacion(identification)
            person.setNombres(names)
            person.setTelefono(phone)
            person.setApellidos(surnames)
            person.setTemperatura(temperature)
            person.setRol(rol)
            readRegistrerInteractor.queryToDataBase(person,this, context)
        }else{
            setIdentificationEmptyError()
        }
    }

    override fun onIdentificationError() {
        readRegistrerView!!.setQueryError()
    }

    override fun onSuccess(persona: Persona) {
        readRegistrerView!!.setDates(persona)
    }

    fun setIdentificationEmptyError(){
        readRegistrerView!!.setIdentificationEmptyError()
    }
}