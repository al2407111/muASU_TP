package com.example.muasu_tp.domain

class AddSensor4_20mA(private val sensor420Listrepository: Sensor4_20_ListRepository) {
    fun addSensor4_20mA(sensor420ma: Sensor4_20mA){
        sensor420Listrepository.addSensor4_20Item(sensor420ma)
    }
}