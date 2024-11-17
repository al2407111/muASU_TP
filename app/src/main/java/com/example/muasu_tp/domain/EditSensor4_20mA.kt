package com.example.muasu_tp.domain

class EditSensor4_20mA(private val sensor420Listrepository: Sensor4_20_ListRepository) {
    fun editSensor4_20mA(sensor420ma: Sensor4_20mA){
        sensor420Listrepository.editSensor4_20Item(sensor420ma)
    }

}