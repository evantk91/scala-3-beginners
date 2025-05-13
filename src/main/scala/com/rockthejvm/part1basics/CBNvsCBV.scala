package com.rockthejvm.part1basics

object CBNvsCBV {

  // CBV = call by value = arguments are evaluated before function invocation
  def aFunction(arg: Int): Int = arg + 1
  val aComputation = aFunction(23 + 67)

  // CBN = call by name = arguments are passed LITERALLY, evaluated at every reference
  def aByNameFunction(arg: => Int): Int = arg + 1
  val anotherComputation = aByNameFunction(23 + 67)

  def printTwiceByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  // x is evaluated at a different time
  // delayed evaluation of the argument
  // argument is evaluated every time it is used
  def printTwiceByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  //expressions that are not evaluated if they are not used in function body
  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y : => Int) = println(x)

  def main(args: Array[String]): Unit = {
    printFirst(42, infinite())
  }
}
