package com.example.redbookproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redbookproject.data.model.Nature
import kotlinx.android.synthetic.main.item.view.*

class NatureListAdapter: RecyclerView.Adapter<NatureListAdapter.NatureListViewHolder>(){
    var models: List<Nature> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class NatureListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(nature: Nature){
            itemView.tv_uzb_name.text = nature.nameUzb
            itemView.tv_rus_name.text = nature.nameRus
            itemView.tv_eng_name.text = nature.nameEng
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NatureListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return NatureListViewHolder(itemView)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: NatureListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
}