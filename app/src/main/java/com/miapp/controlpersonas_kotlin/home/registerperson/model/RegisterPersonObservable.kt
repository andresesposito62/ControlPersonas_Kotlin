package com.miapp.controlpersonas_kotlin.home.registerperson.model

import android.content.Context
import androidx.databinding.BaseObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class RegisterPersonObservable: BaseObservable() {
    private var registerPersonRepositoryImpl: RegisterPersonRepository = RegisterPersonRepositoryImpl()

    fun setRegisterPerson(person: Persona?, context: Context): Long? {
        return registerPersonRepositoryImpl.setRegisterPersonDB(person, context)
    }
}