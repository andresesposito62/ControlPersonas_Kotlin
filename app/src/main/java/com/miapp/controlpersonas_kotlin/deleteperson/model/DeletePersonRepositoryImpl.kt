package com.miapp.controlpersonas_kotlin.deleteperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.databasemanager.PersonRoomEntity
import com.miapp.controlpersonas_kotlin.databasemanager.PersonsDb
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.lang.NullPointerException

class DeletePersonRepositoryImpl: DeletePersonRepository {

    private var statusQuery : Boolean? = null
    private var affectedRegisters: Long? = null

    override fun setDeletePersonApi() {
        TODO("Not yet implemented")
    }

    override fun setDeletePersonDB(person: Persona?, context: Context): Boolean? {

        var implementsInterfaceDeleteFromDataBase = ImplementInterfaceDeleteDatabaseRegistrer()

        try {
            affectedRegisters = implementsInterfaceDeleteFromDataBase.eliminarPersona(person!!, context)
        }catch (e : NullPointerException){}

        finally {
            if(affectedRegisters!= -1L){
                statusQuery = true
            }else{
                statusQuery = false
            }
            return statusQuery
        }
    }

    override suspend fun deleteRegisterPersonDbRoom(person: Persona?, context: Context): Boolean? {

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

            personDao.delete(personRoom)
            result = true

        }catch (e : NullPointerException){
            result = false
        }
        finally {
            return result
        }
    }
}