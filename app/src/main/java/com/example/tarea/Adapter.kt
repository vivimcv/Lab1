package com.example.tarea

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea.databinding.ListViewBinding
import com.example.tarea.movielist

class Adapter(private val context: Context, val datos: ArrayList<movielist>,val onItemListener: OnItemListener): BaseAdapter(){



    private  var layoutInflater= LayoutInflater.from(context)
    private val listMovies = datos

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(p0: Int): Any {
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return datos[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ListViewBinding.inflate(layoutInflater)

        with(binding){
            tvTitulo.text=datos[p0].title
            tvGenero.text= datos[p0].genre
        }
        return binding.root
    }


    interface OnItemListener{

        fun miClick(game: movielist)
    }

    class ViewHolder(binding: ListViewBinding, onItemListener: OnItemListener): RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        private val binding = binding
        private val onItemListener = onItemListener
        private lateinit var peli: movielist

        init{
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemListener.miClick(peli)
        }

        fun bindData(item: movielist){
            with(binding){
                tvTitulo.text = item.title
                tvGenero.text = item.genre

            }
            peli = item
        }
    }
}
