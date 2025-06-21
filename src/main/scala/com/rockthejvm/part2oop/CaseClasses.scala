package com.rockthejvm.part2oop

object CaseClasses {

  // lightweight data structures
  case class Person(name: String, age: Int)
  
  // 1 - class args are now fields
  val daniel = new Person("Daniel", 99)
  val danielsAge: Int = daniel.age
  
  // 2 - toString, equals and hashCode
  val danielToString = daniel.toString // Person("Daniel", 99)
  val danielDuped = new Person("Daniels", 99)
  val isSameDaniel = daniel == danielDuped // true
  
  // 3 - utility methods
  val danielYounger = daniel.copy(age = 78) // new Person("Daniel", 78)
  
  // 4 - CCs have companion objects
  val thePersonSingleton = Person
  val daniel_v2 = Person("Daniel", 99) // "constructor"
  
  // 5 - CCs are serializable
  // use-case: Akka
  
  // 6 - CCs have extractor patterns for PATTERN MATCHING
  
  // can't create CCs with no arg lists
  /*
    case class CCWithNoArgs {
      some code
    }
  
    val ccna = new CCWithNoArgs
    val ccna_v2 = new CCWithNoArgs // all instances would be equal!
   */
  
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
  
  case class CCWithArgListNoArgs[A]() // legal, mainly in the context of generics
  
  /*
    Exercise: use case classes on our linked list implementation
   */
  
  def main(args: Array[String]): Unit = {
    println(daniel)
    println(isSameDaniel)
  }
}
