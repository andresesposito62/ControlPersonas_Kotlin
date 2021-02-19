package com.miapp.controlpersonas_kotlin.readregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

            readRegistrerView?.showProgress()
            searchToDatabase(person)

            //readRegistrerInteractor.queryToDataBase(person,this, context)
        }else{
            setIdentificationEmptyError()
        }
    }

    private fun searchToDatabase(person: Persona){//implementacion corrutina
        CoroutineScope(Dispatchers.IO).launch {
            readRegistrerInteractor.queryToDataBase(person,this@ReadRegistrerPresenter, context)

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