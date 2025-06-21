package com.rockthejvm.part2oop

object Exceptions {

  val aString: String = null
  // aString.length crashes with a NPE
  
  
  // 1 - throw exceptions
//  val aWeirdValue: Int = throw new NullPointerException // returns nothing
  
  // type Throwable
  //   Error, e.g. SOError, OOMError (out of memory)
  //   Exception, e.g. NPE, NSEException, ...
  
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new NullPointerException
    else 42
    
  val potentialFail = try {
    // code that might fail
    getInt(true) // an Int
  } catch {
    // most specific exceptions first
    case e: NullPointerException => 35
    case e: RuntimeException => 54
  } finally {
    // executed no matter what
    // closing resources
    // returns Unit
  }
  
  class MyException extends RuntimeException {
    // fields or methods
    override def getMessage = "MY EXCEPTION"
  }
  
  val myException = new MyException
  
  /*
   * Exercises:
   *
   * 1. Crash with SOError
   * 2. Crash with OOMError
   * 3. Find an element matching a predicate in LList
   */
  
  def soCrash(): Unit = {
    def infinite(): Int = 1 + infinite()
    infinite()
  }
  
  def oomCrash(): Unit = {
    def bigString(n: Int, acc: String): String =
      if(n == 0) acc
      else bigString(n - 1, acc + acc)
      
    bigString(56175363, "Scala")
  }
  
  def main(args: Array[String]): Unit = {
    println(potentialFail)
    
    oomCrash()
  }
}
