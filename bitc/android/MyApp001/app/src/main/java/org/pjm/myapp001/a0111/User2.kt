package org.pjm.myapp001.a0111

class User2(var name:String, var count:Int) {
//    var name:String = "h"
//    var count:Int = 1
    init {
        println("init area...")
        println("name:$name, count:$count")
//        this.name = name
//        this.count = count
    }

    fun some() {
        println("name:$name, count:$count")
    }
}