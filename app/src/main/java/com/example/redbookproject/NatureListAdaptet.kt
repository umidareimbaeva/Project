package com.example.redbookproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.redbookproject.data.model.Nature
import kotlinx.android.synthetic.main.item.view.*

class NatureListAdapter: RecyclerView.Adapter<NatureListAdapter.NatureListViewHolder>(){
    var models: List<Nature> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClick: (natureId: Int) -> Unit = {}

    fun setOnItemClickListener(onItemClick: (natureId: Int) -> Unit){
        this.onItemClick = onItemClick
    }

    inner class NatureListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(nature: Nature){
            itemView.tv_uzb_name.text = nature.nameUzb
            itemView.tv_rus_name.text = nature.nameRus
            itemView.tv_eng_name.text = nature.nameEng
            val imageResource = "picture${nature.id}"
            Glide.with(itemView).load(itemView.context.resources.getIdentifier(imageResource, "drawable", itemView.context.packageName)).into(itemView.img_avatar)
//            itemView.img_avatar.setImageResource(itemView.context.resources.getIdentifier(imageResource,
//                "drawable", itemView.context.packageName))
            itemView.setOnClickListener{
                onItemClick.invoke(nature.id)
            }
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