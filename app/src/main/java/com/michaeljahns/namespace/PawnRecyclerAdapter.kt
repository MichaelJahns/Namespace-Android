package com.michaeljahns.namespace

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michaeljahns.namespace.grammy.Pawn

class PawnRecyclerAdapter(private var pawns: List<Pawn>) : RecyclerView.Adapter<PawnRecyclerAdapter.PawnViewHolder>() {

    inner class PawnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pawnName: TextView = itemView.findViewById(R.id.tvPawnName)
        val pawnProfession: TextView = itemView.findViewById(R.id.tvPawnProfession)
        val pawnAge: TextView = itemView.findViewById(R.id.tvPawnAge)

        init {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PawnRecyclerAdapter.PawnViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pawn_row, parent, false)
        return PawnViewHolder(view)
    }


    //    Whats a better way around this?
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PawnViewHolder, position: Int) {
        holder.pawnName.text = """${pawns[position].name},"""
        holder.pawnProfession.text = pawns[position].profession
        holder.pawnAge.text = pawns[position].age.toString()
    }

    override fun getItemCount(): Int {
        return pawns.size
    }
}