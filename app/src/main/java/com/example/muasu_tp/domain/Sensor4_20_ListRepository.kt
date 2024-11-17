package com.example.muasu_tp.domain

import androidx.lifecycle.LiveData

interface Sensor4_20_ListRepository {
    fun addSensor4_20Item(sensor4_20mA: Sensor4_20mA)
    fun deleteSensor4_20Item(sensor4_20mA: Sensor4_20mA)
    fun editSensor4_20Item(sensor4_20mA: Sensor4_20mA)
    fun getSensor4_20Item(sensor4_20mA: Int):Sensor4_20mA
    fun getSensor4_20List(): LiveData<List<Sensor4_20mA>>
}