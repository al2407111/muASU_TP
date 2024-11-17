package com.example.muasu_tp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.muasu_tp.domain.Sensor4_20_ListRepository
import com.example.muasu_tp.domain.Sensor4_20mA

object Sensor4_20_ListRepositoryImpl:Sensor4_20_ListRepository {
    private val sensor4_20_LD= MutableLiveData <List<Sensor4_20mA>>()
    private val sensor4_20List=sortedSetOf<Sensor4_20mA>( {o1,o2 ->  o1.id.compareTo(o2.id)})
    private var autoIncrement=0



    init {
        for (i in 1 until 22){
            val item=Sensor4_20mA("Name $i",i, true )
            addSensor4_20Item(item)
        }
    }


    override fun addSensor4_20Item(sensor4_20mA: Sensor4_20mA) {
        if (sensor4_20mA.id==Sensor4_20mA.UNDEFINED_ID){
            sensor4_20mA.id=autoIncrement++
        }
        sensor4_20List.add(sensor4_20mA)
        updateList()
    }

    override fun deleteSensor4_20Item(sensor4_20mA: Sensor4_20mA) {
        sensor4_20List.remove(sensor4_20mA)
        updateList()
    }

    override fun editSensor4_20Item(sensor4_20mA: Sensor4_20mA) {
        val oldElement = getSensor4_20Item(sensor4_20mA.id)
        sensor4_20List.remove(oldElement)
        addSensor4_20Item(sensor4_20mA)
    }

    override fun getSensor4_20Item(sensor4_20mAId: Int): Sensor4_20mA {
      return sensor4_20List.find {
          it.id==sensor4_20mAId
      }?:throw RuntimeException("none $sensor4_20mAId")
      }

    override fun getSensor4_20List(): LiveData<List<Sensor4_20mA>> {
       return sensor4_20_LD
    }



    private fun updateList(){
        sensor4_20_LD.value=sensor4_20List.toList()
    }

}