package com.miapp.controlpersonas_kotlin.home.updateperson

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miapp.controlpersonas_kotlin.R

class UpdatePersonFragment : Fragment() {

    companion object {
        fun newInstance() = UpdatePersonFragment()
    }

    private lateinit var viewModel: UpdatePersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.update_person_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpdatePersonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}