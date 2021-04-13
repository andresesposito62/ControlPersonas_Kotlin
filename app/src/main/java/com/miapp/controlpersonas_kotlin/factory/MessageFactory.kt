package com.miapp.controlpersonas_kotlin.factory

import android.content.Context
import android.widget.Toast

class MessageFactory {
    //variable estaticas para que puedan acceder a nuestros tipós desde las otras instancias
    companion object{
        val TYPE_ERROR = "typeError"
        val TYPE_SUCCESS = "typeSuccess"
        val TYPE_DATA_EMPTY = "typeDataEmpty"
    }

    fun getMessage(context : Context, type : String): Toast{// el builder es para poder mostrarlo
        when(type){/* when es como el switch pero de kotlin */
            TYPE_ERROR -> {
                return Toast.makeText(context, "Error al ejecutar la solicitud!", Toast.LENGTH_SHORT)
            }
            TYPE_SUCCESS ->{
                return Toast.makeText(context, "Solicitud realizada satisfactoriamente!", Toast.LENGTH_SHORT)
            }
            TYPE_DATA_EMPTY ->{
                return Toast.makeText(context, "Debes diligenciar los campos obligatorios!", Toast.LENGTH_SHORT)
            }
        }
        return  Toast.makeText(context, "Tipo desconocido", Toast.LENGTH_SHORT)//AlertDialog.Builder(context).setMessage("Necesitas añadir el nuevo tipo")
    }
}