package com.miapp.controlpersonas_kotlin.updateregistrer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.createregistrer.CreateRegistrerInteractor
import com.miapp.controlpersonas_kotlin.createregistrer.CreateRegistrerView
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateRegistrerPresenter : AppCompatActivity{
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

        if(!identification.isEmpty()  && !names.isEmpty()  && !surnames.isEmpty() && !phone.isEmpty()
                && !temperature.isEmpty() && !rol.isEmpty()){
            person.setIdentificacion(identification)
            person.setNombres(names)
            person.setTelefono(phone)
            person.setApellidos(surnames)
            person.setTemperatura(temperature)
            person.setRol(rol)

            updateRegistrerView?.showProgress()
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
            val queryResult : Boolean? = updateRegistrerInteractor.queryToDataBase(person, context)
            runOnUiThread{//todo lo que este aqui se ejecuta en el hilo principal
                updateRegistrerView?.hideProgress()
                if(queryResult != null){
                    updateRegistrerView?.setSucces()
                }else{
                    updateRegistrerView?.setQueryError()
                }
            }
        }
    }

    fun setEmptyValuesError(){
        updateRegistrerView!!.setValuesEmptyError()
    }
}