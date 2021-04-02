package com.miapp.controlpersonas_kotlin.updateregistrer.model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceUpdateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import com.miapp.controlpersonas_kotlin.updateregistrer.ImplementInterfaceUpdateDatabaseRegistrer
import java.lang.NullPointerException

class PersonUpdateRepositoryImpl : PersonUpdateRepository{

    private var statusQuery = MutableLiveData<Boolean>()
    private var resultQuery : Long? = null

    override fun setPersonUpdateApi() {
        TODO("Not yet implemented")
    }

    override fun setPersonUpdateDb(person: Persona?, context: Context): MutableLiveData<Boolean> {


        var implementInterfaceUpdateDatabaseRegistrer : InterfaceUpdateDatabaseRegistrer = ImplementInterfaceUpdateDatabaseRegistrer()

        try {
            resultQuery= implementInterfaceUpdateDatabaseRegistrer.actualizarPersona(person!!, context)
        }catch (e : NullPointerException){}
        finally {
            statusQuery.value = resultQuery!= -1L
            return statusQuery
        }
    }
}