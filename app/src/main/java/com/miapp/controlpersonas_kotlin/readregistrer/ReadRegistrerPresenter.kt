package com.miapp.controlpersonas_kotlin.readregistrer

import android.content.Context
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.logging.Handler
import kotlin.properties.Delegates

class ReadRegistrerPresenter : AppCompatActivity {

    private var readRegistrerView : ReadRegistrerView? = null
    private var readRegistrerInteractor : ReadRegistrerInteractor//? = null
    private var context : Context
    private var person = Persona()
    private var statusQuery : Boolean? = null


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

        if(!identification.isEmpty()){
            person.setIdentificacion(identification)
            person.setNombres(names)
            person.setTelefono(phone)
            person.setApellidos(surnames)
            person.setTemperatura(temperature)
            person.setRol(rol)

            readRegistrerView?.showProgress()
            android.os.Handler().postDelayed({// se pone en un retardo de 2seg simulando una consulta a un servidor externo
                queryToDatabase(person)
            }, 2000)

        }else{
            setIdentificationEmptyError()
        }
    }

    private fun queryToDatabase(person: Persona){//implementacion corrutina
        CoroutineScope(Dispatchers.IO).launch {
            //readRegistrerInteractor.queryToDataBase(person,this@ReadRegistrerPresenter, context)
            val personResult : Persona? = readRegistrerInteractor.queryToDataBase(person, context)
            runOnUiThread{//todo lo que este aqui se ejecuta en el hilo principal
                readRegistrerView?.hideProgress()
                if(personResult != null){
                    readRegistrerView?.setDates(personResult)
                }else{
                    readRegistrerView?.setQueryError()
                }
            }
        }
    }

    fun setIdentificationEmptyError(){
        readRegistrerView!!.setIdentificationEmptyError()
    }


}