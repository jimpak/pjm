package org.pjm.myapp001.a4

fun main() {
    var data = 8


    if (data > 0) {
        println("data > 0")
    } else {
        println("data <= 0")
    }

    println("=====================")

    if (data >= 9) {
        println("9보다 크다")
    } else if (data >= 8) {
        println("9보다 작고 8보다 크거나 같다.")
    } else if (data >= 7) {
        println("8보다 작고 7보다 크거나 같다.")
    } else {
        println("7보다 작다")
    }

    println("=====================")

    val result = if (data > 0) {
        println("0보다 크다")
        true
    } else {
        println("0보다 작거나 같다")
        false
    }
    println("result:$result")
}