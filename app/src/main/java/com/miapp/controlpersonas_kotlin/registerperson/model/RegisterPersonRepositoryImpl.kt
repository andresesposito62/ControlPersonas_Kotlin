package com.miapp.controlpersonas_kotlin.registerperson.model

import android.content.Context
import android.util.Log
import com.miapp.controlpersonas_kotlin.databasemanager.PersonDao_Impl
import com.miapp.controlpersonas_kotlin.databasemanager.PersonRoomEntity
import com.miapp.controlpersonas_kotlin.databasemanager.PersonsDb
import com.miapp.controlpersonas_kotlin.modelo.datos.InterfaceCreateDatabaseRegistrer
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class RegisterPersonRepositoryImpl() : RegisterPersonRepository {

    private var  resultQuery : Long? = null

    override fun setRegisterPersonApi() {
        //
    }

    override fun setRegisterPersonDB(person: Persona?, context: Context): Long? {

        var implementInterfaceCreateDatabaseRegistrer : InterfaceCreateDatabaseRegistrer = ImplementInterfaceCreateDatabaseRegistrer()

        try {
            resultQuery = implementInterfaceCreateDatabaseRegistrer.registrarPersona(person!!, context)
        }catch (e : NullPointerException){}
        finally {
            return resultQuery
        }
    }

    override suspend fun setRegisterPersonDbRoom(person: Persona?, context: Context): Long? {

        var result = 0L

        try {
            val personRoom = PersonRoomEntity(0, person!!.getIdentificacion().toString(),
                person!!.getNombres().toString(),
                person!!.getApellidos().toString(),
                person!!.getTelefono().toString(),
                person!!.getTemperatura().toString(),
                "PARTNER")

            val listPersons: List<PersonRoomEntity> = listOf(personRoom)
            val personDao = (PersonsDb.getDatabase(context.applicationContext)).personDao()

            personDao.insert(listPersons)
            result = 0L
            //Log.d("tag_room", personDao.getAll().toString())
        }catch (e : NullPointerException){
            result = 1L
        }
        finally {
            return result
        }
    }
}
