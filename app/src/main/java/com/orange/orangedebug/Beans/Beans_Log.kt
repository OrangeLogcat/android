package com.orange.orangedebug.Beans

class Beans_Log {
    var tit=ArrayList<String>()
    var data=ArrayList<String>()
    var time=ArrayList<String>()
    fun add(tit:String,data:String,time:String){
        this.tit.add(tit)
        this.data.add(data)
        this.time.add(time)
    }
    fun clear(){
        this.tit.clear()
        data.clear()
        time.clear()
    }
}