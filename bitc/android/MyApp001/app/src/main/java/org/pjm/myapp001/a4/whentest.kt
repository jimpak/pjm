package org.pjm.myapp001.a4

fun main() {
    var data2 = 10


    when(data2) {
        10 -> println("data2 is 10")
        20 -> println("data2 is 20")
        else-> {
            println("data2 is not valid data")
        }
    }

    println("======================")

    var result = when {
        data2 <= 0 -> "data is <= 0"
        data2 > 100 -> "data is > 100"
        else -> "data is not valid"
    }
    println("result:$result")

}