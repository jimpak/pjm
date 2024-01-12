package org.pjm.myapp001.a0111.a3

fun sum(num1:Int, num2:Int):Int {
    return num1 + num2
}

val sum2 = {num1:Int, num2:Int -> num1 + num2}

fun main() {
    val result = sum(10, 20)
    println("result:$result")

    println("result2:${sum2(10, 20)}")

}