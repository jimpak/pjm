package org.pjm.myapp001.a0111.a2

import org.pjm.myapp001.a0111.a1.Person

class Member(name: String, age: Int, var id: String) : Person(name, age) {
    override fun display() {
        println("name:$name, age:$age, id:$id")
    }
}