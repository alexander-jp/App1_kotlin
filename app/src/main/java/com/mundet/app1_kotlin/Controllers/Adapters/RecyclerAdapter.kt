package com.mundet.app1_kotlin.Controllers.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mundet.app1_kotlin.Models.LugaresModel
import com.mundet.app1_kotlin.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyVielHolder>() {
    var context: Context? = null;
    var listLugares: List<LugaresModel> = listOf()


    fun RecyclerAdapter(listLugares: List<LugaresModel>, context: Context) {
        this.listLugares = listLugares;
        this.context = context;
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVielHolder {
        var view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_peliculas, parent, false);
        return MyVielHolder(view);
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return listLugares?.size;

    }

    override fun onBindViewHolder(holder: MyVielHolder, position: Int) {
        holder.txtVNombre?.setText(listLugares?.get(position)?.lugarNombre)
        holder.txtVDescripcion?.setText(listLugares?.get(position)?.lugarDescripcion)
        holder.txtVUbicacion?.setText(listLugares?.get(position)?.lugarUbicacion)

    }


    class MyVielHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtVNombre: TextView? = itemView.findViewById(R.id.txtVNombre);
        var txtVDescripcion: TextView? = itemView.findViewById(R.id.txtVDescripcion);
        var txtVUbicacion: TextView? = itemView.findViewById(R.id.txtVUbicacion);

    }
}