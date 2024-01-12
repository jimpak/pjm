package org.pjm.myapp001.a0111

class User3(name: String) { // 주 생성자는 1개지만 보조 생성자가 여럿일때

    init {
        println("name:$name")
    }

    constructor(name: String, count: Int) : this(name) {
        println("name:$name, count:$count")
    }

    constructor(name: String, count: Int, email: String) : this(name, count) {
        println("name:$name, count:$count, email:$email")
    }
}