package org.pjm.myapp001.a4

fun main() {
    var map = mapOf<String, Int>(Pair("kim", 88), "lee" to 85)
    println(map.get("kim"))
    println(map.get("lee"))
    println(map.keys)
    println(map.values)

    println("======================")

    var map1 = mutableMapOf<String, Int>()
    map1["kim"] = 85
    map1["lee"] = 75
    map1.put("park", 85)
    map1["kim"] = 90
    println(map1.get("kim"))
}