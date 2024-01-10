package org.pjm.myapp001.a2

import org.pjm.myapp001.a1.a

fun some1() {
    var data1:Int=10
//    var data2:Int=null // null은 일반적으론 사용 불가능
    var data3:Int?=null // ?를 활용하여 null을 허용할 수 있음.
    data1 = data1 + 10
    data1 = data1.plus(10)
    println(data1)
}

fun some2() {
    val a1:Byte = 0b00001011
    val a2:Int = 123
    val a3:Short = 123
    val a4:Long = 12L
    val a5:Double = 3.14
    val a6:Float = 3.14f
    val a7:Boolean = true
    val a8:Char = 'A'
    val a9:String = "android"
    val a10:String = """
        hello
        world
        android
    """.trimIndent()
    println("$a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9")
    println("$a10")
}

fun main() {
    println(a)
    println("------------")
    some1()
    println("------------")
    some2()
}