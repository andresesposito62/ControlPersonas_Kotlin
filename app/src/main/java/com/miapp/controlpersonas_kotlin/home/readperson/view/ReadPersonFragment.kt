package com.miapp.controlpersonas_kotlin.home.readperson.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.home.readperson.viewmodel.ReadPersonViewModel

class ReadPersonFragment : Fragment() {

    companion object {
        fun newInstance() = ReadPersonFragment()
    }

    private lateinit var viewModel: ReadPersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.read_person_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReadPersonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}