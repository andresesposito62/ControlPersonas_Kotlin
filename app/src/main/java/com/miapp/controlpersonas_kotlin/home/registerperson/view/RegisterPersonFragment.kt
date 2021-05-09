package com.miapp.controlpersonas_kotlin.home.registerperson.view

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
import com.miapp.controlpersonas_kotlin.databinding.ReadPersonFragmentBinding
import com.miapp.controlpersonas_kotlin.databinding.RegisterPersonFragmentBinding
import com.miapp.controlpersonas_kotlin.factory.MessageFactory
import com.miapp.controlpersonas_kotlin.home.readperson.viewmodel.ReadPersonViewModel
import com.miapp.controlpersonas_kotlin.home.registerperson.viewmodel.RegisterPersonViewModel
import com.miapp.controlpersonas_kotlin.home.singleton.SpinnerActionSingletonObservable
import com.miapp.controlpersonas_kotlin.modelo.domain.Persona

class RegisterPersonFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterPersonFragment()
    }

    private lateinit var spinnerActionSingletonObservable : SpinnerActionSingletonObservable
    private lateinit var viewModel: RegisterPersonViewModel
    private var _binding: RegisterPersonFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var person = Persona()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterPersonFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterPersonViewModel::class.java)
        binding.viewModel = viewModel
        observer()
    }

    fun observer(){
        spinnerActionSingletonObservable = SpinnerActionSingletonObservable.getInstance(requireContext())
        spinnerActionSingletonObservable.getpositionSpinnerActionSelector().observe(viewLifecycleOwner, Observer {
            if (it != 1){
                if (it == 0){
                    findNavController().navigate(R.id.homeFragment)
                }
                else if (it == 2){
                    findNavController().navigate(R.id.readPersonFragment)
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
            person.setIdentificacion(binding.editTextRegistroIdentificacion.text.toString().trim())
            person.setNombres(binding.editTextRegistroNombres.text.toString().trim())
            person.setApellidos(binding.editTextRegistroApellidos.text.toString().trim())
            person.setTelefono(binding.editTextRegistroTelefono.text.toString().trim())
            person.setTemperatura(binding.editTextRegistroTemperatura.text.toString().trim())
            person.setRol("PARTNER")

            if (it){
                if(!person.getIdentificacion().isNullOrEmpty() &&!person.getNombres().isNullOrEmpty() &&
                    !person.getApellidos().isNullOrEmpty() &&!person.getTelefono().isNullOrEmpty() &&
                    !person.getTemperatura().isNullOrEmpty()){

                    viewModel.setRegisterPerson(person, requireContext())

                }else{
                    val messageFactory = MessageFactory()
                    messageFactory.getMessage(requireContext(), MessageFactory.TYPE_DATA_EMPTY).show()
                }
                viewModel.endQuery()
            }
        })

        viewModel.getStatusQuery().observe(viewLifecycleOwner, Observer {
            if (it != 1L){
                val messageFactory = MessageFactory()
                messageFactory.getMessage(requireContext(), MessageFactory.TYPE_SUCCESS).show()
                binding.editTextRegistroIdentificacion.setText("")
                binding.editTextRegistroNombres.setText("")
                binding.editTextRegistroApellidos.setText("")
                binding.editTextRegistroTelefono.setText("")
                binding.editTextRegistroTemperatura.setText("")
            }else{
                val messageFactory = MessageFactory()
                messageFactory.getMessage(requireContext(), MessageFactory.TYPE_ERROR).show()
                binding.editTextRegistroIdentificacion.setText("")
                binding.editTextRegistroNombres.setText("")
                binding.editTextRegistroApellidos.setText("")
                binding.editTextRegistroTelefono.setText("")
                binding.editTextRegistroTemperatura.setText("")
            }
            viewModel.endQuery()
        })
    }

}