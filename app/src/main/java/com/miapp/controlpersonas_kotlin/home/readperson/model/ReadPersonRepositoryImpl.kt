package com.miapp.controlpersonas_kotlin.home.readperson.model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.personread.presenter.PersonReadPresenter
import java.lang.NullPointerException

class ReadPersonRepositoryImpl (): ReadPersonRepository {

    private var personResult : Persona? = null

    override fun getPersonReadApi() {
        TODO("Not yet implemented")
    }

    override fun getPersonReadDB(person: Persona?, context: Context): Persona? {

        var implementInterfaceReadDatabaseRegistrer = ImplementInterfaceReadDatabaseRegistrer()

        try {
            personResult= implementInterfaceReadDatabaseRegistrer.readRegistrerFromDataBase(person!!, context)
        }catch (e : NullPointerException){}

        finally {
            return personResult
        }
    }
}