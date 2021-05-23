package com.miapp.controlpersonas_kotlin.deleteperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.util.*

class DeletePersonObservable: Observable() {
    private var deletePersonRepositoryImpl: DeletePersonRepository = DeletePersonRepositoryImpl()

    suspend fun setDeletePersonDB(person: Persona?, context: Context): Boolean?{
        return deletePersonRepositoryImpl.deleteRegisterPersonDbRoom(person, context)
        //return deletePersonRepositoryImpl.setDeletePersonDB(person, context)
    }
}