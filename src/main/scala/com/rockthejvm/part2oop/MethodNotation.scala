package com.rockthejvm.part2oop

import scala.language.postfixOps

object MethodNotation {

  class Person(val name: String, val age: Int, favoriteMovie: String) {
    // infix position
    infix def likes(movie: String): Boolean =
      movie == favoriteMovie

    def +(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    //exercise #1
    infix def +(nickName: String): Person =
      new Person(s"$name $nickName", age, favoriteMovie)

    def !!(progLanguage: String): String =
      s"$name wonders how can $progLanguage be so cool!"

    // prefix position
    // unary ops: -, +, ~, !
    def unary_- : String =
      s"$name's alter ego"

    //exercise #2
    def unary_+ : Person =
      new Person(name, age + 1, favoriteMovie)

    def isAlive: Boolean = true

    def apply(): String = {
      s"Hi, my name is $name and I really enjoy my $favoriteMovie"
    }

    // exercise #3
    def apply(timesWatched: Int): String = {
      s"$name watched $favoriteMovie $timesWatched times"
    }
  }

  val mary = new Person("Mary", 34, "Inception")
  val john = new Person("John", 36, "Fight Club")

  val negativeOne = -1

  /**
   * Exercises
   * - a + operator on the Person class that returns a person with a nickname
   *   mary + "the rockstar" => new Person("Mary the rockstar", _, _)
   * - a UNARY + operator that increases the person's age
   *   +mary => new Person(_, _, age + 1)
   *  - an apply mehtod with an int arg
   *    mary.apply(2) => "Mary watched Inception 2 times"
   */

  def main(args: Array[String]): Unit = {
    println(mary.likes("Fight Club"))
    // infix notation - for methods with ONE argument
    println(mary likes "Fight Club") // identical

    // "operator" = plain method
    println(mary + john)
    println(mary.+(john)) // identical

    println(mary !! "Scala")

    // prefix position
    println(-mary)

    // postfix position
    println(mary isAlive) // discouraged

    // apply is special
    println(mary.apply())
    println(mary())

    //exercises
    val maryWithNickname = mary + "the rockstar"
    println(maryWithNickname.name)

    val maryAged = +mary
    println(maryAged.age)

    println(mary(2))
  }
}

// method notation summary

// infix notation (object method parameter) - for methods with one parameter
// prefix notation - no parameters, allowed for +, -, !, ~
// postfix notation - no parameters, discouraged, deprecated since scala 2.13
// apply method
