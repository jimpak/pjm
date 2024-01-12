package org.pjm.myapp001.a2

fun some3() {
    var data1: Any = 10 // Any를 사용하면 모든 타입의 변수값을 사용할 수 있음.
    data1 = "Hello"
    data1 = 10.1
}

fun func1(data1: Int, data2: Double): Double { // Double타입으로 결과값을 리턴.
    return data1 + data2
}

fun func2(): Nothing? {
    return null
}

fun func3(): Nothing {
    throw Exception()
}

fun func4(data: Int) {
    val data1 = data + 10
}

fun func5(data1: Int, data2: Int = 10): Int {
    return data1 * data2;
}

fun main() {
    var data = func1(10, 3.14)
    println(data)
    println(func2())

    println(func5(10, 20))
    println(func5(10))
    println(func5(data2 = 20, data1 = 30))
}