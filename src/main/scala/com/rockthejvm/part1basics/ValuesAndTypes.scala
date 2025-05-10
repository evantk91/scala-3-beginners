package com.rockthejvm.part1basics

object ValuesAndTypes {

  // values
  // think of as constants
  // type is optional
  val meaningOfLife: Int = 42

  // re-assigning is not allowed
  // meaningOfLife = 45

  val anInteger = 67 // type is optional, type is inferred

  // common types, essential primitive types
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = 78 // 4 bytes
  val aShort: Short = 5263 // 2 bytes
  val aLong: Long = 52789572389234L // L differentiates from an Integer, 8 bytes
  val aFloat: Float = 2.4f // 4 bytes
  val aDouble: Double = 3.14 // 8 bytes

  // string
  val aString: String = "Scala" // notice this differs from char

  def main(args: Array[String]): Unit = {

  }
}
