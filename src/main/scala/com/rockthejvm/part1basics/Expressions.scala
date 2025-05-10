package com.rockthejvm.part1basics

object Expressions {

  // expressions are structures that can be evaluated to a value
  val meaningOfLife = 40 + 2

  // mathematical expressions: +, -, *, /, bitwise |, &, <<, >>, >>>
  val mathExpression = 2 + 3 * 4

  // comparison expressions: <, <=, >, >=, ==, !=
  val equalityTest = 1 == 2

  // boolean expressions: !, ||, &&
  val nonEqualityTest = !equalityTest

  // instructions vs expressions
  // expressions are evaluated, instructions are executed
  // we think in terms of expressions

  // ifs are expressions
  val aCondition = true
  val anIfExpression = if (aCondition) 45 else 99 // evaluated to a single value

  // code block
  val aCodeBlock = {
    // local value
    val localValue = 78
    // last expression = value of the block
    localValue + 54
  }

  // everything is an expression
  // even function implementations

  /**
   * Exercise:
   * Without running the code, what do you think these values will print out?
   */

  // 1
  val someValue = {
    2 < 3
  }

  // 2
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  // 3
  val yetAnotherValue = println("Scala")

  def main(args: Array[String]): Unit = {
    println(someValue) // true
    println(someOtherValue) // 42
    println(yetAnotherValue)  // (), special type Unit which is equivalent to void
  }
}
