package org.pjm.myapp001.a0111.a3

data class DataClass(val name: String, val email: String, val age: Int) {
    lateinit var address: String

    constructor(name: String, email: String, age: Int, address: String) : this(name, email, age) {
        this.address = address
    }
}
