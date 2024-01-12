package org.pjm.myapp001.a3

fun main() {
    val a = Array<Int>(10, {0}) // 배열 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    println(a)
    println(a.size) // 배열읰 크기
    println(a.contentToString()) // 배열을 string형태로 출력
    a[0] = 10
    a[1] = 20
    a.set(2, 30) // a[2] = 30
    println(a.contentToString())
    println("${a[0]}, ${a[1]}, ${a.get(2)}") // 배열은 중괄호를 사용하여 출력.

    println("=================================")

    val intArray:IntArray = IntArray(3, {1})
    val booleanArray:BooleanArray = BooleanArray(3, {false})
    val doubleArray:DoubleArray = DoubleArray(3, {0.0})
    println(intArray.contentToString())
    println(booleanArray.contentToString())
    println(doubleArray.contentToString())

    println("=================================")

    val data1: IntArray = intArrayOf(1,2,3,4,5)
    val data2 = intArrayOf(1,2,3,4,5)
    val data3 = arrayOf(1,2,3,4,5)
    val days = arrayOf("Sun", "Mon", "Tues", "Wed")
    println(data1.contentToString())
    println(data2.contentToString())
    println(data3.contentToString())
    println(days.contentToString())


}