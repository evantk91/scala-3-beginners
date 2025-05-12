package com.rockthejvm.part1basics

import scala.annotation.tailrec

object Recursion {

  // "repetition" = recursion

  /*
     su(10) = 10 + su(9)
     su(9) = 9 + su(8)
     ...
     su(0) = 0
   */

  def sumUntil(n: Int): Int =
    if(n <= 0) 0
    else n + sumUntil(n - 1) // "stack" recursion


  def sumUntil_v2(n: Int): Int = {
    /*
      sut(10, 0) =
      sut(9, 10) =
      sut(8, 9 + 10) =
      sut(7, 8 + 9 + 10) =
      ...
      sut(0, 1 + 2 + 3 + ... + 10) = 1 + 2 + 3 + ... + 10
     */

    @tailrec
    def sumUntilTailrec(x: Int, accumulator: Int): Int =
      if(x <= 0) accumulator
      else sumUntilTailrec(x - 1, accumulator + x) // tail recursion = recursive call occurs LAST
      // no further stack frames necessary = no more risk of SO

    sumUntilTailrec(n, 0)
  }

  def sumNumbersBetween(a: Int, b: Int): Int =
    if(a > b) 0
    else a + sumNumbersBetween(a + 1, b)


  def sumNumbersBetween_v2(a: Int, b: Int): Int = {
    @tailrec
    def sumTailRec(currentNumber: Int, accumulator: Int): Int =
      if (currentNumber > b) accumulator
      else sumTailRec(currentNumber + 1, currentNumber + accumulator)

    sumTailRec(a, 0)
  }

  /*
   * Exercises
   * 1. Concatenate a string n times
   * 2. Fibonacci function, tail recursive
   * 3. Is isPrime function tail recursive or not?
   */

  // 1
  def concatenate(s: String, n: Int): String = {
     @tailrec
     def concatenateTailrec(n: Int, accumulator: String): String =
       if (n <= 0) accumulator
       else concatenateTailrec(n - 1, accumulator + s)

     concatenateTailrec(n, "")
  }

  // 2
  def fib(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, prev: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + prev, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  // 3
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }
  // isPrimeUntil is tail recursive

  def main(args: Array[String]): Unit = {
    println(sumUntil_v2(20000))
    println(concatenate("Scala", 5))
    println(fib(3))
  }
}
