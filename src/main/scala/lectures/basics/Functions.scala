package lectures.basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

//  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = Expressions.aCodeBlock

//  println(aParameterlessFunction())
  // println(aParameterlessFunction)
  // only works in Scala 2 - parameterless functions are invoked without parentheses

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

//  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }
  /* Function exercises */
  println("Function exercises")
  println("Function 1. Greeting name & age")
  def greeting (name: String, age: Int): Unit = {
    println(s"Hi, my name is $name and I am $age years old")
  }
  greeting("Marcel", 30-1)
  println("Function 2. Factorial of a number")
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }
  println("factorial for " + Variables.any + " is " + factorial(Variables.any))
  println("Function 3. fibonacci sequence")
  def fibonacci(i: Int) : Int = {
    if (i <= 2) 1
    else fibonacci(i - 1) + fibonacci(i - 2)
  }
  def fibonacci_sequence(n: Int): Array[Int] = {
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
    if (n <= 2) Array(1, 1)
    else {
      val previous = fibonacci_sequence(n - 1)
      val next = previous.last + previous(previous.length - 2)
      previous :+ next
    }
  }
  val sequence = if (Variables.any > 10) Variables.any else 10
  println("fibonacci sequence for %d is %d (%d) : %s".format( sequence, fibonacci(sequence),
    fibonacci_sequence(sequence).last, fibonacci_sequence(sequence).mkString(" ")))
  println("Function 4. test if a number is prime")
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(factor: Int): Boolean = {
      factor <= 1 || {
        if (n % factor == 0) false
        else isPrimeUntil(factor - 1)
      }
    }
    isPrimeUntil(n / 2)
  }
  println("Is " + Variables.any + " prime? " + isPrime(Variables.any))
  println("Is " + (Variables.any+1) + " prime? " + isPrime(Variables.any+1))

}
