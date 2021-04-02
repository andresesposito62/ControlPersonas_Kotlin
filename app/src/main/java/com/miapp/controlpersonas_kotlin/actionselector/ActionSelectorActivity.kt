package com.miapp.controlpersonas_kotlin.actionselector

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.deleteregistrer.DeleteRegistrerActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miapp.controlpersonas_kotlin.actionselector.model.Action
import com.miapp.controlpersonas_kotlin.createregistrer.view.PersonCreateActivity
import com.miapp.controlpersonas_kotlin.personread.view.PersonReadActivity
import com.miapp.controlpersonas_kotlin.updateregistrer.view.PersonUpdateActivity

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
            Action("Crear registro","https://elautonomodigital.es/wp-content/uploads/2020/11/Como-registrar-una-marca-o-nombre-comercial-para-tu-empresa.jpg"),
            Action("Leer Registro", "https://www.iebschool.com/blog/wp-content/uploads/2019/09/que-es-digital-business.jpg"),
            Action("Eliminar Registro", "https://www.sba.gov/assets/images/tensteps/plan.jpg"),
            Action("Actualizar Registro", "https://www.elespectador.com/resizer/ibU37GjYXjJjshxv3glRqk2j26U=/657x0/cloudfront-us-east-1.images.arcpublishing.com/elespectador/DT2LC2UFGJCKBD63KBFSCJEBLQ.jpg")
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
        val intent = Intent(this, PersonCreateActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToReadRegistrer(){
        val intent = Intent(this, PersonReadActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToUpdateRegistrer(){
        val intent = Intent(this, PersonUpdateActivity::class.java)
        startActivity(intent)
    }
    override fun navigateToDeleteRegistrer(){
        val intent = Intent(this, DeleteRegistrerActivity::class.java)
        startActivity(intent)
    }
}