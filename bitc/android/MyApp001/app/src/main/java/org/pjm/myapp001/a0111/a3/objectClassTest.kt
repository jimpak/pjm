package org.pjm.myapp001.a0111.a3

open class Super {
    open var data = 10
    open fun some() {
        println("super some():$data")
    }
}

val obj = object : Super() {
    override var data = 10
    override fun some() {
        println("data:$data")
    }
}

fun main() {
    obj.data = 20
    obj.some()
}