package com.miapp.controlpersonas_kotlin.actionselector

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.createregistrer.CreateRegistrerActivity
import com.miapp.controlpersonas_kotlin.deleteregistrer.DeleteRegistrerActivity
import com.miapp.controlpersonas_kotlin.readregistrer.ReadRegistrerActivity
import com.miapp.controlpersonas_kotlin.updateregistrer.UpdateRegistrerActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miapp.controlpersonas_kotlin.actionselector.model.Action

class ActionSelectorActivity : AppCompatActivity(), RecyclerAdapter.OnActionsClickListener, ActionSelectorView{

    private var presenter : ActionSelectorPresenter? = null


    override fun onCreate(savedIntanceState: Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_action_selector)
        setupRecyclerView()
        //rol = findViewById(R.id.editTextPassword)
        presenter = ActionSelectorPresenter(this)
    }

    private fun setupRecyclerView(){
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)//sirve para mostrar los elementos del recicler view
        findViewById<RecyclerView>(R.id.recyclerView).addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val actionList : List<Action> = listOf(
            Action("Crear registro","https://i.blogs.es/ea673c/boton_de_registro/450_1000.png"),
            Action("Leer Registro", "https://www.lo-mejor.com/wp-content/uploads/2020/07/las-mejores-lupas.jpg"),
            Action("Eliminar Registro", "https://www.trecebits.com/wp-content/uploads/2020/05/Borrar-cach%C3%A9-cookies-historial-del-navegador-800x445.jpg"),
            Action("Actualizar Registro", "https://www.anoopcnair.com/wp-content/uploads/2017/11/Windows-10-1709-Fall-Creators-Update-with-Intune-Update-Rings2.jpg")
        )
        findViewById<RecyclerView>(R.id.recyclerView).adapter = RecyclerAdapter(this, actionList, this)
    }

    override fun onItemClick(action: String) {

        if(action.equals("Crear registro")){
            presenter?.createRegistrerPressed()
        }else if(action.equals("Leer Registro")){
            presenter?.readRegistrerPressed()
        }else if(action.equals("Eliminar Registro")){
            presenter?.deleteRegistrerPressed()
        }else if(action.equals("Actualizar Registro")){
            presenter?.updateRegistrerPressed()
        }

    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    fun createRegistrer(view: View){
        presenter?.createRegistrerPressed()
    }

    fun readRegistrer(view: View){
        presenter?.readRegistrerPressed()
    }

    fun updateRegistrer(view: View){
        presenter?.updateRegistrerPressed()
    }

    fun deleteRegistrer(view: View){
        presenter?.deleteRegistrerPressed()
    }

    override  fun navigateToHome(){
        Toast.makeText(this, "Navegando a Home", Toast.LENGTH_SHORT).show()
    }

    override fun navigateToCreateRegistrer(){
        val intent = Intent(this, CreateRegistrerActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToReadRegistrer(){
        val intent = Intent(this, ReadRegistrerActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToUpdateRegistrer(){
        val intent = Intent(this, UpdateRegistrerActivity::class.java)
        startActivity(intent)
    }
    override fun navigateToDeleteRegistrer(){
        val intent = Intent(this, DeleteRegistrerActivity::class.java)
        startActivity(intent)
    }
}