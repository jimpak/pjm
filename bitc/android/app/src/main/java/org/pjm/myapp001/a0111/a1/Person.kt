package org.pjm.myapp001.a0111.a1

// private 다른 클래스에서 접근 불가능. super를 활용하여 접근
// protected : 상속만 받으면 같은 프로젝트의 클래스에서는 접근가능.
open class Person(name:String, age:Int) {
    protected var name:String = "n"
    protected var age:Int = 0
    init {
        this.name = name
        this.age = age
    }

    open fun display() {
        println("name:$name, age:$age")
    }
}

class Student(name:String, age:Int, var major:String):Person(name, age) {
    override fun display() {
//        super.display()
        println("name:$name, age:$age, major:$major")
    }
}

class Employee(name:String, age:Int, var dept:String, var sal:Int):Person(name, age) {
    override fun display() {
//        super.display()
        println("name:$name, age:$age, dept:$dept, sal:$sal")
    }
}