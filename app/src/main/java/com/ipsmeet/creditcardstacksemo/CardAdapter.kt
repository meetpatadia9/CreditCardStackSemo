package com.ipsmeet.creditcardstacksemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ipsmeet.creditcardstacksemo.databinding.ItemCardBinding

class CardAdapter(private val context: Context, private val cardList: List<Int>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(val itemBinding: ItemCardBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = ItemCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.apply {
            itemBinding.imgvCard.setImageResource(cardList[position])
        }
    }

}