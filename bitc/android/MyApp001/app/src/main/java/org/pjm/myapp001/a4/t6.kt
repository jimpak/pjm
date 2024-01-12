package org.pjm.myapp001.a4

fun main() {

    val list = listOf<Int>(10,20,30)
    println("""
        list.size:${list.size}
        list.data:${list[0]}, ${list[1]}, ${list.get(2)}
    """.trimIndent())

    println("===========================")

    var mulatableList = mutableListOf<Int>(10,20,30)
    mulatableList.add(40)
    mulatableList.add(50)
    mulatableList.set(0, 100)
    println(mulatableList.get(0))
    println(mulatableList.get(1))
    println("""
        mulatableList.size: ${mulatableList.size}
        mulatableList.data: 
            ${mulatableList.get(0)}
            ${mulatableList.get(1)}
            ${mulatableList.get(2)}
            ${mulatableList.get(3)}
            ${mulatableList.get(4)}
    """.trimIndent())

}