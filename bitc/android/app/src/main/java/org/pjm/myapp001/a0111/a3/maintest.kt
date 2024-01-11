package org.pjm.myapp001.a0111.a3

fun main() {
    val non1 = NonDataClass("kim", "a@a", 20)
    val non2 = NonDataClass("kim", "a@a", 20)

    println("non data class equals:${non1.equals(non2)}")


    val data1 = DataClass("kim", "a@a", 20)
    val data2 = DataClass("kim", "a@a", 20)

    println("data class equals:${data1.equals(data2)}")


    val data3 = DataClass("kim", "a@a", 20, "seoul")
    val data4 = DataClass("kim", "a@a", 20, "busan")

    println("data class equals:${data3.equals(data4)}")


    //toString()
    println("non data class toString: ${non1.toString()}")
    println("data class toString: ${data1.toString()}")
}