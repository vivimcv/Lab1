package com.example.tarea.ui.gallery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea.Adapter
import com.example.tarea.R
import com.example.tarea.databinding.FragmentGalleryBinding
import com.example.tarea.movielist
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.list_view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.coroutines.NonDisposableHandle.parent

///////LISTADO DE PELÍCULAS
class GalleryFragment : Fragment(),Adapter.OnItemListener {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var viewOfLayout: View

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var peliculas = ArrayList<movielist>()
    var arrayList: ArrayList<movielist> = ArrayList()
    var i : Long =1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

      /*  val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        //return LayoutInflater.from(container?.context).inflate(R.layout.fragment_gallery, container, false)
      //  return root
       /* val view: View = inflater.inflate(R.layout.fragment_gallery, container, false)
        userlist = view.findViewById(R.id.userlist)
        userlist.setOnClickListener {
            // Aquí código del click :)
        }*/
       // viewOfLayout = inflater!!.inflate(R.layout.fragment_gallery, container, false)
      //  root.textView.text = "hello"   //add your view before id else will get nullpointer exception

        return root
    }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     //hola?.setText("hello, world")

       val lv = userlist as ListView

       val arrayAdapter: ArrayAdapter<*>

       val datos = ArrayList<movielist>()

       /*for(i in 1 until 20){
           val movieTmp = movielist(i, "Título $i", "Género $i")
           datos.add(movieTmp)

       }*/

       arrayList.add(movielist(1, "Crepúsculo", "drama"))
       arrayList.add(movielist(2, "Batman", "acción"))
       arrayList.add(movielist(3, "Titanic", "drama"))
       arrayList.add(movielist(4, "El castillo vagabundo","anime"))

       val adapter = Adapter(requireContext(),arrayList,this)
       userlist.adapter = adapter
      // val adapter = Adapter(requireContext(), datos)

       binding.userlist.adapter = adapter
       binding.userlist.setOnItemClickListener { adapterView, view, i, l ->
           val peliSelected = adapterView.adapter.getItem(i) as movielist
           val itemAtPos = adapterView.getItemAtPosition(i)
           val itemIdAtPos = adapterView.getItemIdAtPosition(i)
          // Toast.makeText(context, "${itemIdAtPos} ", Toast.LENGTH_LONG).show()
           //Toast.makeText(context, "${peliSelected.title} Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()


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



       /*  arrayAdapter = ArrayAdapter(this,
             android.R.layout.activity_list_item, users)
         userlist.adapter = arrayAdapter*/

     /*
       //un solo texto en la lista********
       val data = java.util.ArrayList<String>()
       data.add("Crepúsculo")
       data.add("Batman")
       data.add("Titanic")
       data.add("El pianista")

       val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, data)
       userlist.adapter = adapter*/


   }



   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.userlist)
    }*/



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

}