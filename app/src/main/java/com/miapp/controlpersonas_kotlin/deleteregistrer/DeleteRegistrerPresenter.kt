package com.miapp.controlpersonas_kotlin.deleteregistrer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteRegistrerPresenter : AppCompatActivity {

    private var deleteRegistrerView :DeleteRegistrerView? = null
    private var deleteRegistrerInteractor : DeleteRegistrerInteractor//? = null
    private var context : Context
    private var person = Persona()


    constructor(deleteRegistrerView: DeleteRegistrerView, deleteRegistrerInteractor: DeleteRegistrerInteractor, context: Context){
        this.deleteRegistrerView = deleteRegistrerView
        this.deleteRegistrerInteractor = deleteRegistrerInteractor
        this.context = context
    }


    fun deleteRegistrer(identification : String, names : String, surnames : String, phone: String,
                      temperature : String, rol : String ){
        if(deleteRegistrerView != null){
            //  readRegistrerView?.showProgress()
        }

        if(!identification.isEmpty()){
            person.setIdentificacion(identification)
            deleteRegistrerView?.showProgress()
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
            val personResult : Boolean? = deleteRegistrerInteractor.queryToDataBase(person, context)
            runOnUiThread{//todo lo que este aqui se ejecuta en el hilo principal
                deleteRegistrerView?.hideProgress()
                if(personResult != null){
                    deleteRegistrerView?.setSucces()
                }else{
                    deleteRegistrerView?.setQueryError()
                }
            }
        }
    }

    fun setIdentificationEmptyError(){
        deleteRegistrerView!!.setIdentificationEmptyError()
    }

}