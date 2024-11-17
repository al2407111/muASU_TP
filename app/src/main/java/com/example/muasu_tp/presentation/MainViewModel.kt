package com.example.muasu_tp.presentation

import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import com.example.muasu_tp.data.Sensor4_20_ListRepositoryImpl
import com.example.muasu_tp.domain.DeleteSensor4_20mA
import com.example.muasu_tp.domain.EditSensor4_20mA
import com.example.muasu_tp.domain.GetListSensor4_20mA
import com.example.muasu_tp.domain.Sensor4_20mA

class MainViewModel : ViewModel(){

    private val repository=Sensor4_20_ListRepositoryImpl
    private val getSensor4_20= GetListSensor4_20mA(repository)
    private val deleteSensor4_20= DeleteSensor4_20mA(repository)
    private val editSensor4_20= EditSensor4_20mA(repository)


    val sensor4_20maList=getSensor4_20.getListSensor4_20mA()

    fun deleteSensor4_20(sensor4_20mA:Sensor4_20mA){
        deleteSensor4_20.deleteSensor4_20mA(sensor4_20mA)
    }
fun changeEnableState(sensor4_20mA:Sensor4_20mA){
    val newItem=sensor4_20mA.copy(enabled = !sensor4_20mA.enabled)

    editSensor4_20.editSensor4_20mA(newItem)
    }
}