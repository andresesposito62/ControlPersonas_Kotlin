package com.miapp.controlpersonas_kotlin.updateperson.model

import android.content.Context
import android.util.Log
import com.miapp.controlpersonas_kotlin.databasemanager.PersonRoomEntity
import com.miapp.controlpersonas_kotlin.databasemanager.PersonsDb
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceUpdateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class UpdatePersonRepositoryImpl : UpdatePersonRepository {

    private var statusQuery: Boolean? = null
    private var resultQuery : Long? = null

    override fun setPersonUpdateApi() {
        TODO("Not yet implemented")
    }

    override fun setPersonUpdateDb(person: Persona?, context: Context): Boolean? {


        var implementInterfaceUpdateDatabaseRegistrer : InterfaceUpdateDatabaseRegistrer = ImplementInterfaceUpdateDatabaseRegistrer()

        try {
            resultQuery= implementInterfaceUpdateDatabaseRegistrer.actualizarPersona(person!!, context)
        }catch (e : NullPointerException){}
        finally {
            if (resultQuery != -1L){
                statusQuery = true
            }else{
                statusQuery = false
            }
            return statusQuery
        }
    }

    override suspend fun updateRegisterPersonDbRoom(person: Persona?, context: Context): Boolean? {

        var result = false

        try {
            val personDao = (PersonsDb.getDatabase(context.applicationContext)).personDao()
            val personRoom= personDao.getById(person!!.getIdentificacion().toString())

            personRoom.indentification = person!!.getIdentificacion().toString()
            personRoom.names = person!!.getNombres().toString()
            personRoom.surnames = person!!.getApellidos().toString()
            personRoom.phone = person!!.getTelefono().toString()
            personRoom.temperature = person!!.getTemperatura().toString()
            personRoom.rol = person!!.getRol().toString()

            personDao.update(personRoom)
            result = true

        }catch (e : NullPointerException){
            result = false
        }
        finally {
            return result
        }
    }
}