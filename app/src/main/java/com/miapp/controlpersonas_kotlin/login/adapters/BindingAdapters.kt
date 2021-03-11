package com.miapp.controlpersonas_kotlin.login.adapters

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {
    //los bindings adapter se basan en metodos estaticos por eso el JVMStatic
    @JvmStatic
    @BindingAdapter("visible")
    fun View.bindVisible(visible : Boolean?){
        visibility = if (visible == true) View.VISIBLE else View.GONE
    }
}