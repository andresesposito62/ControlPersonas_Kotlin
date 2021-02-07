package com.miapp.controlpersonas_kotlin.deleteregistrer

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class DeleteRegistrerPresenter : DeleteRegistrerInteractor.OnLoginFinishedListener {

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

        if(identification != ""){
            person.setIdentificacion(identification)
            deleteRegistrerInteractor.queryToDataBase(person,this, context)
        }else{
            setIdentificationEmptyError()
        }
    }

    override fun onIdentificationError() {
        deleteRegistrerView!!.setQueryError()
    }

    override fun onSuccess() {
        deleteRegistrerView!!.setDates()
    }

    fun setIdentificationEmptyError(){
        deleteRegistrerView!!.setIdentificationEmptyError()
    }

}