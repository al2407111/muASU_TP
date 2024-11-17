package com.example.muasu_tp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.muasu_tp.domain.Sensor4_20mA

class Sensor4_20MaListDiffCallback (
    private val oldList: List<Sensor4_20mA>,
    private val newList: List<Sensor4_20mA>,
    ): DiffUtil.Callback(){

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem == newItem
        }
    }