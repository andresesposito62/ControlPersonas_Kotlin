package com.miapp.controlpersonas_kotlin.login.adapters

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

object BindingAdapter {
    //los bindings adapter se basan en metodos estaticos por eso el JVMStatic
    @JvmStatic
    @BindingAdapter("visibility")
    fun setVisibility(view : View, visibility : Boolean){
        if (visibility == true){
            view.visibility = View.VISIBLE
        }else{
            view.visibility = View.GONE
        }
    }


    @InverseBindingAdapter(attribute = "android:text")
    fun EditText.getFloatFromBinding(): Float? {
        val result=text.toString()
        return result.toFloat()
    }
}