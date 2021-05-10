package com.miapp.controlpersonas_kotlin.deleteperson.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.databinding.DeletePersonFragmentBinding
import com.miapp.controlpersonas_kotlin.databinding.ReadPersonFragmentBinding
import com.miapp.controlpersonas_kotlin.factory.MessageFactory
import com.miapp.controlpersonas_kotlin.deleteperson.viewmodel.DeletePersonViewModel
import com.miapp.controlpersonas_kotlin.singleton.SpinnerActionSingletonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class DeletePersonFragment : Fragment() {

    companion object {
        fun newInstance() = DeletePersonFragment()
    }

    private lateinit var spinnerActionSingletonObservable : SpinnerActionSingletonObservable
    private lateinit var viewModel: DeletePersonViewModel
    private var _binding: DeletePersonFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var person = Persona()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DeletePersonFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeletePersonViewModel::class.java)
        binding.viewModel = viewModel
        observers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observers(){
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

        viewModel.getInitQuery().observe(viewLifecycleOwner, Observer {

            person.setIdentificacion(binding.editTextIEliminacionIdentificacion.text.toString().trim())

            if (it){
                if(!person.getIdentificacion().isNullOrEmpty()){
                    viewModel.setQueryDeletePerson(person, requireContext())
                }else{
                    val messageFactory = MessageFactory()
                    messageFactory.getMessage(requireContext(), MessageFactory.TYPE_DATA_EMPTY).show()
                    binding.editTextIEliminacionIdentificacion.setText("")
                }
                viewModel.endQuery()
            }
        })

        viewModel.getStatusQuery().observe(viewLifecycleOwner, Observer {
            if (it){
                val messageFactory = MessageFactory()
                messageFactory.getMessage(requireContext(), MessageFactory.TYPE_SUCCESS).show()
            }else{
                val messageFactory = MessageFactory()
                messageFactory.getMessage(requireContext(), MessageFactory.TYPE_ERROR).show()
            }
        })
    }
}