package com.rockthejvm.part3fp

object WhatsAFunction {

  // FP: functions are "first-class" citizens
  // JVM
  
  trait MyFunction[A, B] {
    def apply(arg: A): B
  }
  
  val doubler = new MyFunction[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }
  
  val meaningOfLife = 42
  val meaningDoubled = doubler(meaningOfLife) // doubler.apply(meaningOfLife)
  
  // function types
  val doublerStandard = new (Int => Int) {
    override def apply(arg: Int): Int = arg * 2
  }
  val meaningDoubled_v2 = doublerStandard(meaningOfLife)
  
  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  val anAddition = adder(2, 67)
  
  // all functions are instances of FunctionX with apply methods
  
  /*
   * Exercises
   * 1. A function which takes 2 strings and concatenates them
   * 2. Replace predicate/transformer with the appropriate function types if necessary
   * 3. Define a function which takes an int as an argument and returns ANOTHER function as a result
   */

  // Exercise #1
  val concatenateStr = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  // Exercise #2
  // yes, Predicate[T] equivalent with Function1[T, Boolean] === T => Boolean
  // yes, Transformer[A, B] equivalent with Function1[A, B] === A => B

  // Exercise #3
  val superAdder = new Function1[Int, Function1[Int, Int]] {
     override def apply(x: Int) = new Function1[Int, Int] {
       override def apply(y: Int) = x + y
     }  
  }

  private val adder2 = superAdder(2)
  val anAddition_v2: Int = adder2(67)
  // currying
  val anAddition_v3 = superAdder(2)(67)

  // function values != methods
  
  def main(args: Array[String]): Unit = {
    val result = concatenateStr("cat", "dog")
    println(result)
  }
}
