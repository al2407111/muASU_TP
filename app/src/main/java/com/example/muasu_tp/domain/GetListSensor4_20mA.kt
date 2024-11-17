package com.example.muasu_tp.domain

import androidx.lifecycle.LiveData

class GetListSensor4_20mA(private val sensor420Listrepository: Sensor4_20_ListRepository) {
    fun getListSensor4_20mA():LiveData<List<Sensor4_20mA>>{
        return  sensor420Listrepository.getSensor4_20List()
    }
}