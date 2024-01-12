package org.pjm.myapp001.a0111.a1

import org.pjm.myapp001.a0111.a2.Member

fun main() {
    var p1 = Person("Lee", 20)
    p1.display()

    var s1 = Student("Kim", 20, "AI")
    s1.display()

    println("==========================")

    var e1 = Employee("Hong", 35, "영업", 500)
    e1.display()

    println("==========================")

    var m1 = Member("Park", 20, "user00")
    m1.display()
    var m2:Person = Member("Park", 20, "user00")
    m2.display()
}