package org.pjm.myapp001.a0111

class User {
    var name = "Hong"
    var age:Int = 10
    constructor(name:String) {
        this.name = name
    }

    constructor(name:String, age:Int) {
        this.name = name
        this.age = age
    }

    fun someFun() {
        println("name: $name")
    }

    class SomeClass{}
}

fun main() {
    val user1 = User("kim")
    user1.someFun()
    val user2 = User("lee", 25)
    user2.someFun()

    println("=====================")

    val s1 = Student(2, "Park", "AI")
    s1.some()

    println("=====================")

    var user3 = User2("hong", 30)
    user3.some()

    println("=====================")

    val user3_1 = User3("Kim")
    println("---------------------")
    val user3_2 = User3("Hong", 20)
    println("---------------------")
    val user3_3 = User3("Hong", 20, "abc@naver.com")
}