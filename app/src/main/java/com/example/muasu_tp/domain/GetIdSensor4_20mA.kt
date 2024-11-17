package com.example.muasu_tp.domain

class GetIdSensor4_20mA(private val sensor420Listrepository: Sensor4_20_ListRepository) {
    fun getIdSensor4_20mA(sensor4_20maId: Int):Sensor4_20mA{
        return sensor420Listrepository.getSensor4_20Item(sensor4_20maId)
    }
}