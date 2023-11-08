package com.example.apprestaurante

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CustomAdapter (private val mList: List<itemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class  ViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.img_plato)
        val tituloPrincipal: TextView = itemView.findViewById(R.id.lbl_nombre_plato)
        val descripcionSecundaria: TextView = itemView.findViewById(R.id.lbl_descripcion_plato)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_platos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Si deseo alguna conexion podria ser aqui (BDs, Servicio Web, entre otros)
        val itemViewModel = mList[position]

        holder.imageView.setImageResource(itemViewModel.image)
        holder.tituloPrincipal.text = itemViewModel.titulo
        holder.descripcionSecundaria.text = itemViewModel.descripcion
    }
}