package com.rockthejvm.part2oop

object Inheritance {

  class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch() = {
      eat()
      println("crunch, crunch")
    }
  }

  val cat = new Cat

  class Person(val name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name) // must specify super-constructor

  // overriding - give more specific implementations
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat(): Unit = println("mm, I like this bone")

    // popular overridable method
    override def toString: String = "a dog"
  }

  // subtype polymorphism
  val dog: Dog = new Dog
  dog.eat() // the most specific method will be called

  // overloading vs overriding
  class Crocodile extends Animal {
    override val creatureType = "very wild"
    override def eat(): Unit = println("I can eat anything, Im a croc")

    // overloading: multiple methods with the same name, different signatures
    // different signature =
    //   different argument list (different number of args + different arg types)
    //   + different return type (optional)
    def eat(animal: Animal): Unit = println("Im eating this poor fella")
    // valid overloads
    def eat(dog: Dog): Unit = println("eating a dog")
    def eat(person: Person): Unit = println("I'm eating a human")
    def eat(person: Person, dog: Dog): Unit = println("I'm eating a human and the dog")
    def eat(dog: Dog, person: Person): Unit = println("I'm eating a human and the dog")
    // the point is for the compiler to not get confused and call the correct method
  }

  def main(args: Array[String]): Unit = {
    println(dog) // println(dog.toString)

    val croc = new Crocodile
    val daniel = new Person("daniel", 99)

    croc.eat(dog, daniel)
  }
}
