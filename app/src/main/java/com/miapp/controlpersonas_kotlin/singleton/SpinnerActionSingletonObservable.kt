package com.miapp.controlpersonas_kotlin.singleton

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*


class SpinnerActionSingletonObservable private constructor(context: Context): Observable() {
        /*fun doSomething() {
        }*/

        private var positionSpinnerActionSelector = MutableLiveData<Int>()

        fun getpositionSpinnerActionSelector(): MutableLiveData<Int> {
            return positionSpinnerActionSelector
        }

        fun setPositionSpinnerActionSelector(position: Int){
            positionSpinnerActionSelector.value = position
        }

        companion object : SingletonHolder<SpinnerActionSingletonObservable, Context>(::SpinnerActionSingletonObservable)
}






