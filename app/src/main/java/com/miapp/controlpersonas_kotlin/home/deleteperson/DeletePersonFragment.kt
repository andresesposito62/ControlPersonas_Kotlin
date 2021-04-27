package com.miapp.controlpersonas_kotlin.home.deleteperson

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miapp.controlpersonas_kotlin.R

class DeletePersonFragment : Fragment() {

    companion object {
        fun newInstance() = DeletePersonFragment()
    }

    private lateinit var viewModel: DeletePersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.delete_person_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeletePersonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}