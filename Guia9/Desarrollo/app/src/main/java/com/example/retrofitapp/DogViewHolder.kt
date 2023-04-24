package com.example.retrofitapp

import android.content.ClipData.Item
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder {
    private val itemDogBinding: ItemDogBinding

    init{
        itemDogBinding = ItemDogBinding.bind(view!!)
    }

    fun bind(imageUrl: String?){
        Picasso.get().load(imageUrl).into(itemDogBinding.ivDog)
    }

}