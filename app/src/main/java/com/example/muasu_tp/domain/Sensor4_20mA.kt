package com.example.muasu_tp.domain

data class Sensor4_20mA (
    val name:String,
    val count: Int,
    val enabled:Boolean,
//    val  mA_out_min: Long,
//    val mA_out_max: Long,
//    val minOut: Long,
//    val maxOut: Long,
//    val out:  Long,
//    val input: Long,
    var id : Int=UNDEFINED_ID
)


//    constructor(_name: String, _count: Int, _enabled: Boolean)
//    {
//        name = _name
//        enabled=_enabled
//        count=_count
//    }
{
    companion object{
        const val UNDEFINED_ID=-1
    }

}






