package playground

import lectures.basics.*

object ScalaPlayground {
  private val values: Values.type = Values
  private val valuesPlayground: Unit = {
    println("Playground of "+values.getClass)
    val one = values.x
    println(one)
    println("two: " + values.two)
    println("three: " + values.three)
    println("four: " + values.four)
    println("five: " + values.five)
    println("six: " + values.six)
    println("seven: " + values.seven)
    println("eight: " + values.eight)
    println("nine: " + values.nine)
    println("ten: " + values.ten)
    println("eleven: " + values.eleven)
    println("twelve: " + values.twelve)
  }
  private val expressions: Unit = {
    val obj = Expressions
    println("Playground of "+obj.getClass)
    println("x:" + obj.x)
    println("y:" + obj.y)
    println("z:" + obj.z)
  }
  private val functions: Unit = {
    println("Playground of "+Functions.getClass)
    println("aFunction: " + Functions.aFunction(Expressions.greeting, Variables.any))
    println("aParameterlessFunction: " + Functions.aParameterlessFunction())
    println("aRepeatedFunction: " + Functions.aRepeatedFunction(Expressions.greeting, Variables.any))
    println("aSideEffectFunction: " + Functions.aFunctionWithSideEffects(Expressions.hello))
    println("aBigFunction: " + Functions.aBigFunction(Functions.aParameterlessFunction()))
    println("factorial: " + Functions.factorial(0))
    println("fibonacci for 8 is %d : %s".format(Functions.fibonacci(8),
      Functions.fibonacci_sequence(8).mkString(", ")))
    println("Is 37 is Prime:" + Functions.isPrime(37))
    println("Is 2003 is Prime:" + Functions.isPrime(2003))
  }
  def main(args: Array[String]): Unit = {
    val recursionPlayground = {
      println("Playground of " + Recursion.getClass)
      println("factorial: " + Recursion.factorial(20000))
      println("anotherFactorial: " + Recursion.anotherFactorial(20000))
      val callByNameOrValue = {
        Array(CallByValue, CallByName)
      }
      println("Playground of " + callByNameOrValue.map(
        callByNameOrValue => callByNameOrValue.getClass).mkString(", "))
    }
    val defaultArgsPlayground = {
      println("Playground of " + DefaultArgs.getClass)
      println("factorial with default arguments setted: " + DefaultArgs.fact10)
      println("factorial with default arguments only n(21000): " + DefaultArgs.factorial(21000))
      println("savePicture: ")
      DefaultArgs.savePicture(height=600, width=800)
    }
    val stringOperations = {
      println("Playground of " + StringOperations.getClass)
      val obj = StringOperations
      obj.str = "Hi, My name is maquinterocar"
      println(obj.str.charAt(2))
      println(obj.str.substring(7, 11))
      println(obj.str.split(" ").toList)
      println(obj.str.startsWith("Hello"))
      println(obj.str.replace(" ", "-"))
      println(obj.str.toLowerCase())
      println(obj.str.length)
      println(obj.str.reverse)
      println(obj.str.take(2))
    }
  }
}
