package com.example.muasu_tp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.muasu_tp.R


class MainActivity : AppCompatActivity() {
    //  private var count = 0
    private lateinit var viewModel: MainViewModel

    private lateinit var sensor4_20ListAdapter: Sensor4_20ListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.sensor4_20maList.observe(this) {
            sensor4_20ListAdapter.shopList = it
        }
    }

    private fun setupRecyclerView() {
        val rvSensor4_20List = findViewById<RecyclerView>(R.id.rv_shop_list)
        with(rvSensor4_20List) {
            sensor4_20ListAdapter = Sensor4_20ListAdapter()
            adapter = sensor4_20ListAdapter
            recycledViewPool.setMaxRecycledViews(
                Sensor4_20ListAdapter.VIEW_TYPE_ENABLED,
                Sensor4_20ListAdapter.MAX_POOL_ZIZE
            )
            recycledViewPool.setMaxRecycledViews(
                Sensor4_20ListAdapter.VIEW_TYPE_DISABLED,
                Sensor4_20ListAdapter.MAX_POOL_ZIZE
            )
        }


        setupLongClicListener()

        setupSwipeListener(rvSensor4_20List)
        setupClickListener()



    }

    private fun setupLongClicListener() {
        sensor4_20ListAdapter.onShopItemLongClickListener = {
            viewModel.changeEnableState(sensor4_20mA = it)
        }
    }

    private fun setupSwipeListener(rvShopList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = sensor4_20ListAdapter.shopList[viewHolder.adapterPosition]
                viewModel.deleteSensor4_20(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    private fun setupClickListener() {
        sensor4_20ListAdapter.onShopItemClickListener = {
            Log.d("MainActivity", it.toString())

        }
    }
}


