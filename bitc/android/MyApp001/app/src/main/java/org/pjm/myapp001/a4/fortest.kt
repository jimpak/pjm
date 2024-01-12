package org.pjm.myapp001.a4

fun main() {
    var sum: Int = 0 // int sum = 0
    for (i in 1..10) { // 1부터 10까지
        sum += i
    }
    println("sum:$sum")

    println("========================")
    sum = 0;

    for(i in 1 until 10) { // 1부터 9까지
        println(i)
    }

    println("========================")

    for(i in 0 .. 10 step 2) { // 2씩 증가
        println(i)
    }

    println("========================")

    for(i in 10 downTo 1) { // 10부터 1까지 -1처리
        println(i)
    }


}