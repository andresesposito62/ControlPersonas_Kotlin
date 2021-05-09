package com.miapp.controlpersonas_kotlin.home.updateperson.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.miapp.controlpersonas_kotlin.R
import com.miapp.controlpersonas_kotlin.databinding.RegisterPersonFragmentBinding
import com.miapp.controlpersonas_kotlin.databinding.UpdatePersonFragmentBinding
import com.miapp.controlpersonas_kotlin.factory.MessageFactory
import com.miapp.controlpersonas_kotlin.home.singleton.SpinnerActionSingletonObservable
import com.miapp.controlpersonas_kotlin.home.updateperson.viewmodel.UpdatePersonViewModel
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class UpdatePersonFragment : Fragment() {

    companion object {
        fun newInstance() = UpdatePersonFragment()
    }

    private lateinit var spinnerActionSingletonObservable : SpinnerActionSingletonObservable
    private lateinit var viewModel: UpdatePersonViewModel
    private var _binding: UpdatePersonFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var person = Persona()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UpdatePersonFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpdatePersonViewModel::class.java)
        binding.viewModel = viewModel
        observers()
    }

    fun observers(){
        spinnerActionSingletonObservable = SpinnerActionSingletonObservable.getInstance(requireContext())
        spinnerActionSingletonObservable.getpositionSpinnerActionSelector().observe(viewLifecycleOwner, Observer {
            if (it != 3){
                if (it == 0){
                    findNavController().navigate(R.id.homeFragment)
                }
                else if (it == 1){
                    findNavController().navigate(R.id.registerPersonFragment)
                }
                else if (it == 2){
                    findNavController().navigate(R.id.readPersonFragment)
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
            person.setIdentificacion(binding.editTextActualizacionIdentificacion.text.toString().trim())
            person.setNombres(binding.editTextActualizacionNombres.text.toString().trim())
            person.setApellidos(binding.editTextActualizacionApellidos.text.toString().trim())
            person.setTelefono(binding.editTextActualizacionTelefono.text.toString().trim())
            person.setTemperatura(binding.editTextActualizacionTemperatura.text.toString().trim())
            person.setRol("PARTNER")

            if (it){
                if(!person.getIdentificacion().isNullOrEmpty() &&!person.getNombres().isNullOrEmpty() &&
                    !person.getApellidos().isNullOrEmpty() &&!person.getTelefono().isNullOrEmpty() &&
                    !person.getTemperatura().isNullOrEmpty()){

                    viewModel.setUpdatePerson(person, requireContext())

                }else{
                    val messageFactory = MessageFactory()
                    messageFactory.getMessage(requireContext(), MessageFactory.TYPE_DATA_EMPTY).show()
                }
                viewModel.endQuery()
            }
        })

        viewModel.getStatusQuery().observe(viewLifecycleOwner, Observer {
            if (it){
                val messageFactory = MessageFactory()
                messageFactory.getMessage(requireContext(), MessageFactory.TYPE_SUCCESS).show()
                binding.editTextActualizacionIdentificacion.setText("")
                binding.editTextActualizacionNombres.setText("")
                binding.editTextActualizacionApellidos.setText("")
                binding.editTextActualizacionTelefono.setText("")
                binding.editTextActualizacionTemperatura.setText("")
            }else{
                val messageFactory = MessageFactory()
                messageFactory.getMessage(requireContext(), MessageFactory.TYPE_ERROR).show()
                binding.editTextActualizacionIdentificacion.setText("")
                binding.editTextActualizacionNombres.setText("")
                binding.editTextActualizacionApellidos.setText("")
                binding.editTextActualizacionTelefono.setText("")
                binding.editTextActualizacionTemperatura.setText("")
            }
            viewModel.endQuery()
        })
    }
}