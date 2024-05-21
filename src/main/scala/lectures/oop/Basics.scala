package lectures.oop

import lectures.basics.StringOperations

object Basics extends App{
  val person = new Person("Marcel", 30-1)
  person.age = 20
  println(person.name + " is " + person.age + " years old")
}
// constructor is class instruction with parameters
// class parameters are no fields, must be set as val|var
class Person (val name: String, var age: Int) : // or { ... }
  // body
  val x = 2
  println(1 + 3)

  //method of Person class
  def greeting(name: String) = println(s"${this.name} says: hello, $name")

  // method  greeting overloaded
  def greeting() = println(s"Hello, world my name is $name")

  // Multiple constructors
  def this(name: String) = this(name, StringOperations.age)
  def this() = this(StringOperations.name, StringOperations.age)

/* Exercises*/
class Writer (firstname:String, var lastname:String = "", val year: Int) {
  def fullname = "%s %s".format(firstname, lastname)
}

class Novel (name:String, year: Int, author: Writer) :
  def authorAge = year - author.year
  def isWrittenBy (author: Writer) = this.author == author
  def copy (yearCopy: Int) = new Novel(name, yearCopy, author)

class Counter (var n: Int = 0) :
  def increment =
    println("incrementing.")
    new Counter(n + 1)
  def decrement =
    println("decrementing.")
    new Counter(n - 1)
  def increment(n: Int) : Counter = if (n <= 0) this else increment.increment(n-1)
  def decrement(n: Int) : Counter = if (n <= 0) this else decrement.decrement(n-1)
  def print = 
    println(n) 
    this
