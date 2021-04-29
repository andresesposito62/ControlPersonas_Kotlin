package com.miapp.controlpersonas_kotlin.home.deleteperson

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.home.singleton.SpinnerActionSingletonObservable

class DeletePersonFragment : Fragment() {

    companion object {
        fun newInstance() = DeletePersonFragment()
    }

    private lateinit var spinnerActionSingletonObservable : SpinnerActionSingletonObservable
    private lateinit var viewModel: DeletePersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observer()
        return inflater.inflate(R.layout.delete_person_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeletePersonViewModel::class.java)
        // TODO: Use the ViewModel
    }
    fun observer(){
        spinnerActionSingletonObservable = SpinnerActionSingletonObservable.getInstance(requireContext())
        spinnerActionSingletonObservable.getpositionSpinnerActionSelector().observe(viewLifecycleOwner, Observer {
            if (it != 4){
                if (it == 0){
                    findNavController().navigate(R.id.homeFragment)
                }
                else if (it == 1){
                    findNavController().navigate(R.id.registerPersonFragment)
                }
                else if (it == 2){
                    findNavController().navigate(R.id.readPersonFragment)
                }
                else if (it == 3){
                    findNavController().navigate(R.id.updatePersonFragment)
                }
                else if (it == 5){
                    findNavController().navigate(R.id.exportDataFragment)
                }
            }
        })
    }
}