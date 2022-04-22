package com.example.tarea.ui.registro

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.tarea.Adapter
import com.example.tarea.R
import com.example.tarea.databinding.FragmentGalleryBinding
import com.example.tarea.databinding.FragmentRegistroBinding
import com.example.tarea.movielist
import com.example.tarea.ui.gallery.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*

class RegistroFragment : Fragment(), Adapter.OnItemListener {


    private var _binding: FragmentRegistroBinding? = null
    private lateinit var viewOfLayout: View
    private val binding get() = _binding!!
    private var peliculas = ArrayList<movielist>()
    var arrayList: ArrayList<movielist> = ArrayList()
    var i : Long =1


    companion object {
        fun newInstance() = RegistroFragment()
    }

    private lateinit var viewModel: RegistroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val galleryViewModel =
            ViewModelProvider(this).get(RegistroViewModel::class.java)

        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lv = userlist as ListView

        val arrayAdapter: ArrayAdapter<*>

        val datos = ArrayList<movielist>()
        arrayList.add(movielist(1, "Crepúsculo", "drama"))
        arrayList.add(movielist(2, "Batman", "acción"))
        arrayList.add(movielist(3, "Titanic", "drama"))
        arrayList.add(movielist(4, "El castillo vagabundo","anime"))

        val adapter = Adapter(requireContext(),arrayList,this)
        userlist.adapter = adapter

        binding.userlist.adapter = adapter
        binding.userlist.setOnItemClickListener { adapterView, view, i, l ->
            val peliSelected = adapterView.adapter.getItem(i) as movielist
            val itemAtPos = adapterView.getItemAtPosition(i)
            val itemIdAtPos = adapterView.getItemIdAtPosition(i)


            when(itemIdAtPos.toInt()){

                //  1 -> Toast.makeText(context, "tres", Toast.LENGTH_LONG).show()
                1 -> Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_mainActivity22)
                2 -> Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_mainActivity3)
                3 -> Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_mainActivity43)
                4 -> Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_mainActivity5)
                //  1 -> Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_videoFragment)
                // 2 -> Toast.makeText(context, "dos ", Toast.LENGTH_LONG).show()
                else -> Toast.makeText(context, "tres", Toast.LENGTH_LONG).show()
            }


        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun miClick(movie: movielist) {
        Toast.makeText(requireContext(), "Juego: ${movie.title}", Toast.LENGTH_SHORT).show()

        val bundle = Bundle()
        bundle.putString("dato1", "${movie.title}")
        parentFragmentManager.setFragmentResult("datos",bundle)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistroViewModel::class.java)
        // TODO: Use the ViewModel
    }


}