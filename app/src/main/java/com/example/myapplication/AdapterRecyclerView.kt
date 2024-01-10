package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AdapterRecyclerView(var listaUsuarios: MutableList<Persona>, private val listener: OnClickListener): RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder
}