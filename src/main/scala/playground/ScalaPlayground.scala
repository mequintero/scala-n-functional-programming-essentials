package playground

import lectures.basics.{Expressions, Values}

object ScalaPlayground {
  private val values: Values.type = Values
  private val values_playground = {
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
  private val expressions = {
    val obj = Expressions
    println("Playground of "+obj.getClass)
    println("x:" + obj.x)
    println("y:" + obj.y)
    println("z:" + obj.z)
  }
  def main(args: Array[String]): Unit = {
    values_playground
    expressions
  }
}
