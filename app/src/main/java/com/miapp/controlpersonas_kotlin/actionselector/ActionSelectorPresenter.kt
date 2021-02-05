package com.miapp.controlpersonas_kotlin.actionselector

class ActionSelectorPresenter {

    private var actionSelectorView : ActionSelectorView? = null

    constructor(actionSelectorView: ActionSelectorView){
        this.actionSelectorView = actionSelectorView
    }

    /*fun onResume(){
        if(actionSelectorView != null) {
            //actionSelectorView?.navigateToReadRegistrer()
        }
    }*/

    fun onResume() {

    }

    fun createRegistrerPressed(){
        if(actionSelectorView !=null){
            actionSelectorView?.navigateToCreateRegistrer()
        }
    }

    fun readRegistrerPressed(){
        if(actionSelectorView !=null){
            actionSelectorView?.navigateToReadRegistrer()
        }
    }

    fun updateRegistrerPressed(){
        if(actionSelectorView !=null){
            actionSelectorView?.navigateToUpdateRegistrer()
        }
    }

    fun deleteRegistrerPressed(){
        if(actionSelectorView !=null){
            actionSelectorView?.navigateToDeleteRegistrer()
        }
    }
}