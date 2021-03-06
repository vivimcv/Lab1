package com.example.tarea.ui.registro

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.tarea.Adapter
import com.example.tarea.R
import com.example.tarea.databinding.FragmentRegistroBinding
import com.example.tarea.movielist
import com.example.tarea.ui.gallery.GalleryViewModel
import com.example.tarea.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*

class RegistroFragment : Fragment(){

    private var _binding: FragmentRegistroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(RegistroViewModel::class.java)

        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            with(binding) {
                if (validaCampos()) {
                    validaSeisCaracteres()

                    //val numero = Integer.parseInt(etNumero.text.toString())
                    //    val numero = editTextTextPassword.text.toString().toInt()
                    //    if (esMagico(numero)) tvResultado.text = getString(R.string.si_magico, numero, "!")
                    //    else tvResultado.text = getString(R.string.no_magico, numero)


                } else {

                    //    Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show()
                    editTextTextPassword.error = "Ingresa al menos seis caracteres, entre ellos una letra y un n??mero"
                    editTextTextPassword.requestFocus()

                }
            }
            //  Navigation.findNavController(view).navigate(R.id.nav_gallery)
            // Toast.makeText(this@HomeFragment,"aqui", Toast.LENGTH_SHORT ).show()
            //   Toast.makeText(this@HomeFragment, getString(R.string.ingresa_numero), Toast.LENGTH_SHORT).show()
        }
    }


    private fun validaCampos(): Boolean{

        if(binding.editTextTextPassword.text.toString() != "")return  true
        //  if(binding..text.toString() != "" ) return true
        //  Toast.makeText(this, getString(R.s))
        // Toast.makeText(this@HomeFragment, getString(R.string.ingresa_numero), Toast.LENGTH_SHORT).show()
        else return false


    }


    private fun validaSeisCaracteres(): Boolean{

        //    val input = Integer.parseInt(binding.editTextTextPassword.toString() )


        val input = binding.editTextTextPassword.getText().toString().trim().length
        val password = binding.editTextTextPassword.getText().toString()
        if (input > 6){
            // Toast.makeText(getContext(), "mayor a seis ", Toast.LENGTH_SHORT).show()
            // if (){

            isValidPassword(password)
            if (isValidPassword(password.trim())) {
              //  Toast.makeText(getContext(), password, Toast.LENGTH_SHORT).show()
                Toast.makeText(getContext(), "Contrase??a v??lida", Toast.LENGTH_SHORT).show();
            } else {
              //  Toast.makeText(getContext(), password, Toast.LENGTH_SHORT).show()
                Toast.makeText(getContext(), "Contrase??a invalida", Toast.LENGTH_SHORT).show();
            }
            return true



        }else{
            Toast.makeText(getContext(), "La contrase??a debe contener m??s de seis caracteres. ", Toast.LENGTH_SHORT).show()
            return false

        }


    }
    fun isValidPassword(password: String?) : Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z]).{6,}$"
            // val passwordPattern = "(/^(?=.*\\d)(?=.*[A-Z])([@\$%&#])[0-9a-zA-Z]{4,}\$/)"
            // val passwordPattern = " ^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }


}