package lectures.basics

import scala.annotation.tailrec

object Recursion extends App{
  var acc: BigInt = 1
  val printable = false
  @tailrec
  def factorial(n: Int): BigInt =
    acc *= n
    if (n <= 1) acc
    else
      if (printable)
        println("Recursion using acc for " + n + " needs calculate factorial for " + (n - 1))
      factorial(n - 1)

//  println(Functions.factorial(5000)) // stack overflow!
  println("Recursion using acc for 6 returns " +factorial(6))
  println("Recursion using acc for 30000 returns " +factorial(30000))

  def anotherFactorial(n: Int): BigInt =
    @tailrec
    def accumulator(n: Int, acc: BigInt): BigInt =
      if (n <= 1) acc
      else accumulator(n - 1, n * acc)
    accumulator(n, 1)

  println("Recursion for 5000 returns " +anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  @tailrec
  def concatenateAnyTimes(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateAnyTimes(aString, n - 1, aString + accumulator)

  println("Exercise 1.  Concatenate a string n times")
  println(concatenateAnyTimes("hello", 3, ""))

  def isPrime(n: Int): Boolean =
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else (t <= 1) || isPrimeUntil(t - 1, n % t != 0 && isStillPrime)

    isPrimeUntil(n / 2, true)

  println("Exercise 2.  IsPrime function tail recursive")
  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int =
    @tailrec
    def fibonacciSequence(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciSequence(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciSequence(2, 1, 1)

  println("Exercise 3.  Fibonacci function, tail recursive")
  println(fibonacci(8))

}