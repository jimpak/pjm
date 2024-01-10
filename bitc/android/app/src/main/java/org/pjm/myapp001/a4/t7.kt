package org.pjm.myapp001.a4

fun main() {
    val names = listOf<String>("kim","hong","choi")
    println(names.get(0))

    var names1 = mutableListOf<String>("kim","hong","choi")
    names1.add("park")
    names1.set(0, "lee")
    println(names1.get(0))
    for(i in 0 until names.size) {
        println(names.get(i))
    }
}