package org.pjm.myapp001.a1

// 초기화 미루기
lateinit var doto10:String
val doto5 by lazy { 10 }

//변수 선언하기
val a = 10 // val : 값 변경 불가
var b = 10 // var : 값 변경 가능
var c : Int = 5
var d : Double = 3.14
var a1 : Int = 0; // 전역변수에서는 반드시 초기값을 설정해 줘야 한다.
fun main() {
    var a1 : Int // 전역변수로 설정하면 오류발생하지만, 함수 안에서는 정상적으로 적용됨.
    b = 30

    println("Hello android")
    println("Hong")
    println(20)

    some()
    some2()
}

class User {
    lateinit var name : String

    var d1 = Int
    val d2 = String
    var data : Int=10 // 클래스 또한 초기값 설정 안하면 오류 발생
    var data2 : Int=20
}

fun some() {
    val d1 : Int
    val d2 : Int
    d1 = 10
    d2 = 20
    println("$d1, $d2")
}

fun some2() {
    var user:User

    doto10 = "android"
    println(doto10)
    println(doto5)
}