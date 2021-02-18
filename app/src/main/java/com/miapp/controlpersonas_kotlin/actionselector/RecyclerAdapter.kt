package com.miapp.controlpersonas_kotlin.actionselector

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.actionselector.base.BaseViewHolder
import com.miapp.controlpersonas_kotlin.actionselector.model.Action
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    private val context : Context,
    private val actionList : List<Action>,
    private val itemClickListener: OnActionsClickListener
    ) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnActionsClickListener{
        fun onItemClick(action: String)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {//infla la vista, contiene los datos
        return ActionsViewHolder(LayoutInflater.from(context).inflate(R.layout.actions_row, parent, false))
    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {//toma toda la informacion de la lista y se lo pone a cada uno de los elementos
        when(holder){
            is ActionsViewHolder -> holder.bind(actionList[position], position)
            else -> IllegalArgumentException("El view holder no es correcto")
        }
    }

    override fun getItemCount(): Int {//Devuelve la cantidad de datos que tiene que inflar
        return actionList.size
    }

    inner class ActionsViewHolder(itemView : View) : BaseViewHolder<Action>(itemView){
        override fun bind(item: Action, position: Int) {
            itemView.setOnClickListener { itemClickListener.onItemClick(item.action) }
            Glide.with(context).load(item.imagen).into(itemView.findViewById<ImageView>(R.id.img_action))
            itemView.findViewById<TextView>(R.id.txt_nombre_action).text =item.action
        }

    }
}