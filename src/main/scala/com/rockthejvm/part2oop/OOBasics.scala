package com.rockthejvm.part2oop

object OOBasics {

  // classes
  class Person(val name: String = "Jane", age: Int = 0) { // constructor structure
    // fields
    val allCaps = name.toUpperCase()

    // methods
    def greet(name: String): String = {
      s"${this.name} says: Hi, $name" // this refers to current instance
    }

    // signature differs
    // OVERLOADING
    def greet(): String = {
      s"Hi, everyone, my name is $name" // there is no need to disambiguate
    }

    // aux constructor
    def this(name: String) =
      this(name, 0)

    def this() =
      this("Jane Doe")
  }

  val aPerson: Person = new Person("John", 26)
  val john = aPerson.name // class parameter != field
  val johnSayHiToDaniel = aPerson.greet("Daniel")
  val johnSaysHi = aPerson.greet()

  val genericPerson = new Person()

  def main(args: Array[String]): Unit = {
    val charlesDickens = new Writer("Charles", "Dickens", 1812)
    val charlesDickensImposter = new Writer("Charles", "Dickens", 2021)
    println(charlesDickens.fullname)

    val novel = new Novel("Great Expectations", 1861, charlesDickens)
    val newEdition = novel.copy(1871)

    println(novel.authorAge)
    println(newEdition.authorAge)
    println(novel.isWrittenBy(charlesDickens))

    val counter = new Counter()
    counter.print() // 0
    counter.increment().print() // 1
    counter.increment() // always returns new instances
    counter.print()

    counter.increment(10).print()
    counter.increment(20000).print()
  }
}

/**
  Exercise: imagine we're creating a backend for a book publishing house.
  Create a Novel and a Writer class.

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
*/

class Writer(firstName: String, lastName: String, val yearOfBirth: Int) {
  def fullname: String = s"$firstName $lastName"
}

class Novel(title: String, yearOfRelease: Int, author: Writer) {
   def authorAge : Int = yearOfRelease - author.yearOfBirth
   def isWrittenBy(author: Writer): Boolean = this.author == author
   def copy(newYear: Int): Novel = new Novel(title, newYear, author)
}

/**
 Exercise #2: an immutable counter class
 - counstructed with an initial count
 - increment/decrement => NEW instance of counter
 - increment(n)/decrement(n) => NEW instance of counter
 - print()

 Benefits
 - works well in distributed environments
 - easier to read and understand code
 */

class Counter(count: Int = 0) {
  def increment(): Counter = new Counter(count + 1)

  def decrement(): Counter =
    if (count == 0) this
    else new Counter(count - 1)

  def increment(n: Int): Counter =
    if(n <= 0) this
    else increment().increment(n - 1) // vulnerable to stack overflow

  def decrement(n: Int): Counter =
    if(n <= 0) this
    else decrement().decrement(n - 1)

  def print(): Unit =
    println(s"Current count: $count")
}




