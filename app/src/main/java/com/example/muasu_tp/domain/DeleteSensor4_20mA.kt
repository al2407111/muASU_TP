package com.example.muasu_tp.domain

class DeleteSensor4_20mA (private val sensor420Listrepository: Sensor4_20_ListRepository) {
  fun  deleteSensor4_20mA(sensor4_20ma: Sensor4_20mA){
      sensor420Listrepository.deleteSensor4_20Item(sensor4_20ma)
  }

}