package com.miapp.controlpersonas_kotlin.readperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.databasemanager.PersonRoomEntity
import com.miapp.controlpersonas_kotlin.databasemanager.PersonsDb
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
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

    override suspend fun getRegisterPersonDbRoom(person: Persona?, context: Context): Persona? {

        var personResult = Persona()

        try {
            val personDao = (PersonsDb.getDatabase(context.applicationContext)).personDao()
            val personRoom =  personDao.getById(person!!.getIdentificacion().toString())
            personResult!!.setIdentificacion(personRoom.indentification)
            personResult!!.setNombres(personRoom.names)
            personResult!!.setApellidos(personRoom.surnames)
            personResult!!.setTelefono(personRoom.phone)
            personResult!!.setTemperatura(personRoom.temperature)
            personResult!!.setRol(personRoom.rol)
            //Log.d("tag_room", personDao.getAll().toString())

        }catch (e : NullPointerException){
        }
        finally {
            return personResult
        }
    }
}