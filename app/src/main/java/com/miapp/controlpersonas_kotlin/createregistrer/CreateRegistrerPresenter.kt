package com.miapp.controlpersonas_kotlin.createregistrer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateRegistrerPresenter :AppCompatActivity {
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

        if(!identification.isEmpty()  && !names.isEmpty()  && !surnames.isEmpty() && !phone.isEmpty()
                && !temperature.isEmpty() && !rol.isEmpty()){
            person.setIdentificacion(identification)
            person.setNombres(names)
            person.setTelefono(phone)
            person.setApellidos(surnames)
            person.setTemperatura(temperature)
            person.setRol(rol)
            //createRegistrerInteractor.queryToDataBase(person, context)

            createRegistrerView?.showProgress()
            android.os.Handler().postDelayed({// se pone en un retardo de 2seg simulando una consulta a un servidor externo
                queryToDatabase(person)
            }, 2000)
        }else{
            setEmptyValuesError()
        }
    }

    private fun queryToDatabase(person: Persona){//implementacion corrutina
        CoroutineScope(Dispatchers.IO).launch {
            //readRegistrerInteractor.queryToDataBase(person,this@ReadRegistrerPresenter, context)
            val queryResult : Boolean? = createRegistrerInteractor.queryToDataBase(person, context)
            runOnUiThread{//todo lo que este aqui se ejecuta en el hilo principal
                createRegistrerView?.hideProgress()
                if(queryResult != null){
                    createRegistrerView?.setSucces()
                }else{
                    createRegistrerView?.setQueryError()
                }
            }
        }
    }

    fun setEmptyValuesError(){
       createRegistrerView!!.setValuesEmptyError()
    }


}