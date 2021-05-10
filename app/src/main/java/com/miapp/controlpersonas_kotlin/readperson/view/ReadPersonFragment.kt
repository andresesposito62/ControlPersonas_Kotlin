package com.miapp.controlpersonas_kotlin.readperson.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.databinding.ReadPersonFragmentBinding
import com.miapp.controlpersonas_kotlin.factory.MessageFactory
import com.miapp.controlpersonas_kotlin.exportdata.ExportDataViewModel
import com.miapp.controlpersonas_kotlin.readperson.viewmodel.ReadPersonViewModel
import com.miapp.controlpersonas_kotlin.singleton.SpinnerActionSingletonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class ReadPersonFragment() : Fragment() {

    companion object {
        fun newInstance() = ReadPersonFragment()
    }

    private lateinit var spinnerActionSingletonObservable : SpinnerActionSingletonObservable
    private lateinit var viewModel: ReadPersonViewModel
    private var _binding: ReadPersonFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var person = Persona()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ReadPersonFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReadPersonViewModel::class.java)
        binding.viewModel = viewModel
        observers()
    }

    fun observers(){
        spinnerActionSingletonObservable = SpinnerActionSingletonObservable.getInstance(requireContext())
        spinnerActionSingletonObservable.getpositionSpinnerActionSelector().observe(viewLifecycleOwner, Observer {
            if (it != 2){
                if (it == 0){
                    findNavController().navigate(R.id.homeFragment)
                }
                else if (it == 1){
                    findNavController().navigate(R.id.registerPersonFragment)
                }
                else if (it == 3){
                    findNavController().navigate(R.id.updatePersonFragment)
                }
                else if (it == 4){
                    findNavController().navigate(R.id.deletePersonFragment)
                }
                else if (it == 5){
                    findNavController().navigate(R.id.exportDataFragment)
                }
            }
        })

        viewModel.getInitQuery().observe(viewLifecycleOwner, Observer {

            person.setIdentificacion(binding.editTextConsultaIdentificacion.text.toString().trim())

            if (it){
                if(!person.getIdentificacion().isNullOrEmpty()){
                    viewModel.queryDataPerson(person, requireContext())
                }else{
                    val messageFactory = MessageFactory()
                    messageFactory.getMessage(requireContext(), MessageFactory.TYPE_DATA_EMPTY).show()
                    binding.editTextConsultaIdentificacion.setText("")
                    binding.editTextConsultaNombres.setText("")
                    binding.editTextConsultaApellidos.setText("")
                    binding.editTextConsultaTelefono.setText("")
                    binding.editTextConsultaTemperatura.setText("")
                }
                viewModel.endQuery()
            }
        })

        viewModel.getDataPersonReaded().observe(viewLifecycleOwner, Observer {
            if (!it?.getIdentificacion().isNullOrEmpty() && !it?.getNombres().isNullOrEmpty()&&
                !it?.getApellidos().isNullOrEmpty() && !it?.getTelefono().isNullOrEmpty()&&
                !it?.getTemperatura().isNullOrEmpty()){

                binding.editTextConsultaIdentificacion.setText(it?.getIdentificacion())
                binding.editTextConsultaNombres.setText(it?.getNombres())
                binding.editTextConsultaApellidos.setText(it?.getApellidos())
                binding.editTextConsultaTelefono.setText(it?.getTelefono())
                binding.editTextConsultaTemperatura.setText(it?.getTemperatura())
            }else{
                val messageFactory = MessageFactory()
                messageFactory.getMessage(requireContext(), MessageFactory.TYPE_ERROR).show()
                binding.editTextConsultaIdentificacion.setText("")
                binding.editTextConsultaNombres.setText("")
                binding.editTextConsultaApellidos.setText("")
                binding.editTextConsultaTelefono.setText("")
                binding.editTextConsultaTemperatura.setText("")
            }
        })
    }
}


