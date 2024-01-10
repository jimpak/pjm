package org.pjm.myapp001.a4

fun main() {
    var data:IntArray = intArrayOf(10, 20, 30)

    for (i in data.indices) {
        print(data[i])
        if(i !== data.size - 1) { // i가 마지막 index와 같지 않다면
            print(",")
        }
    }

    println("\n=======================")

    for((index, value) in data.withIndex()) {
        print(value)
        if(index !== data.size - 1) {
            print(",")
        }
    }

    println("\n=======================")

    for(i in data) { // java의 향상된 for문 쓰던 방식과 같음.
        println(i)
    }

    println("=======================")

    for (i in 1 .. 5) {
        for (j in 1 .. i) {
            print("*")
        }
        println()
    }
}