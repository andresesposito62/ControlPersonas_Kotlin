package com.miapp.controlpersonas_kotlin.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeActivityViewModel: ViewModel() {

    private var positionSpinnerActionSelector = MutableLiveData<Int>()

    fun getpositionSpinnerActionSelector(): LiveData<Int> {
        return positionSpinnerActionSelector
    }

}