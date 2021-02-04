package com.miapp.controlpersonas_kotlin.actionselector

class ActionSelectorPresenter : ActionSelectorInteractor{

    private var actionSelectorView: ActionSelectorView? = null
    private var actionSelectorInteractor : ActionSelectorInteractor? = null

    constructor(actionSelectorView: ActionSelectorView, actionSelectorInteractor: ActionSelectorInteractor){
        this.actionSelectorView = actionSelectorView
        this.actionSelectorInteractor = actionSelectorInteractor
    }

    fun chooseActivity(string: String) {
        if(actionSelectorView != null){
            //if(string.equals("READ_REGISTRER")){
               //actionSelectorView?.navigateToReadRegistrer()
            //}
        }
    }

    fun onDestroy(){
        actionSelectorView = null
    }
}