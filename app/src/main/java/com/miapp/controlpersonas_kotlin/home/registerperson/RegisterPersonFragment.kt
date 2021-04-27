package com.miapp.controlpersonas_kotlin.home.registerperson

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miapp.controlpersonas_kotlin.R

class RegisterPersonFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterPersonFragment()
    }

    private lateinit var viewModel: RegisterPersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_person_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterPersonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}