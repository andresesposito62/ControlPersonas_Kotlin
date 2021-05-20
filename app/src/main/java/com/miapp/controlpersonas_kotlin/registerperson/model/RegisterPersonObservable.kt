package com.miapp.controlpersonas_kotlin.registerperson.model

import android.content.Context
import androidx.databinding.BaseObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class RegisterPersonObservable: BaseObservable() {
    private var registerPersonRepositoryImpl: RegisterPersonRepository = RegisterPersonRepositoryImpl()

    suspend fun setRegisterPerson(person: Persona?, context: Context): Long? {
        return registerPersonRepositoryImpl.setRegisterPersonDbRoom(person, context)
       // return registerPersonRepositoryImpl.setRegisterPersonDB(person, context)
    }
}