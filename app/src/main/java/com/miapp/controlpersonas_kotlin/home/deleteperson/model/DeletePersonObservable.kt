package com.miapp.controlpersonas_kotlin.home.deleteperson.model

import android.content.Context
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona
import java.util.*

class DeletePersonObservable: Observable() {
    private var deletePersonRepositoryImpl: DeletePersonRepository = DeletePersonRepositoryImpl()

    fun setDeletePersonDB(person: Persona?, context: Context): Boolean?{
        return deletePersonRepositoryImpl.setDeletePersonDB(person, context)
    }
}