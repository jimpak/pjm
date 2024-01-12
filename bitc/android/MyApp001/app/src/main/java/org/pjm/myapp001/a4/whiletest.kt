package org.pjm.myapp001.a4

fun main() {
    var x = 0;
    var sum1 = 0
    while(x < 10) {
        sum1 += ++x
    }
    print("x:$x, sum1:$sum1")
}