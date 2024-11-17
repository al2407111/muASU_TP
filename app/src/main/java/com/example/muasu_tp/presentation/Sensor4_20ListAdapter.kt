package com.example.muasu_tp.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.muasu_tp.R
import com.example.muasu_tp.domain.Sensor4_20mA

class Sensor4_20ListAdapter:RecyclerView.Adapter<Sensor4_20ListAdapter.SensorItemViewHolder>() {
    var count = 0
    var sensor4_20List = listOf<Sensor4_20mA>()
        set(value) {
            val callback = Sensor4_20MaListDiffCallback(sensor4_20List, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }


var onShopItemLongClickListener: ((Sensor4_20mA)-> Unit)?=null

var onShopItemClickListener: ((Sensor4_20mA)-> Unit)?=null

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorItemViewHolder {
    Log.d("ShopListAdapter","onCreateViewHolder, count: ${++count}")
    val layout=when(viewType){
        VIEW_TYPE_DISABLED-> R.layout.item_sensor4_20_disabled
        VIEW_TYPE_ENABLED-> R.layout.item_sensor4_20_enabled
        else -> {throw RuntimeException("else item_shop")}
    }
    val view = LayoutInflater.from(parent.context).inflate(
        layout,
        parent,
        false
    )
    return SensorItemViewHolder(view)
}

override fun onBindViewHolder(viewHolder: SensorItemViewHolder, position: Int) {
    val shopItem = sensor4_20List[position]

    viewHolder.view.setOnLongClickListener {
        //    onShopItemLongClickListener?.onShopItemLongClickListener(shopItem)
        onShopItemLongClickListener?.invoke(shopItem)
        true
    }
    viewHolder.view.setOnClickListener {
        onShopItemClickListener?.invoke(shopItem)

    }
    viewHolder.tvName.text = shopItem.name
    viewHolder.tvCount.text = shopItem.count.toString()


}

override fun getItemCount(): Int {
    return sensor4_20List.size
}

override fun getItemViewType(position: Int): Int {
    val item=sensor4_20List[position]
    return if(item.enabled){
        VIEW_TYPE_ENABLED
    }else{
        VIEW_TYPE_DISABLED
    }
}

class SensorItemViewHolder(val view: View):RecyclerView.ViewHolder(view) {

    val tvName=view.findViewById<TextView>(R.id.tv_name)
    val tvCount=view.findViewById<TextView>(R.id.tv_count)
}

interface OnShopItemLongClickListener{
    fun onShopItemLongClickListener(sensor4_20mA:Sensor4_20mA)
}


companion object{
    const val VIEW_TYPE_ENABLED=100
    const val VIEW_TYPE_DISABLED=101
    const val MAX_POOL_ZIZE=25 //мощность устройства или экран устройства размер
}
}