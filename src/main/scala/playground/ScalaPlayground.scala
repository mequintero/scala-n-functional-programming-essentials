package playground

import lectures.basics.*
import lectures.oop.*

import java.text.SimpleDateFormat
import java.util.Date
import scala.language.postfixOps
import exercises.{Consecutive, Empty}

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
    println("Playground for " + Basics.getClass)
    Basics.person.greeting()
    Basics.person.greeting("Marcel")
    val asWriter = new Writer(firstname = Basics.person.name,
      year = SimpleDateFormat("yyyy").format(Date()).toInt - 30 + 1)
    val novel = new Novel(StringOperations.greeting, asWriter.year + Basics.person.age, asWriter)
    println("authorAge of Novel:" + novel.authorAge)
    asWriter.lastname = "Quintero"
    val impostor = new Writer(StringOperations.name, asWriter.lastname, asWriter.year)
    println(s"authorName of Novel is ${impostor.fullname}?: ${novel.isWrittenBy(impostor)}")
    println("authorName of Novel is %s?: %b".format(asWriter.fullname, novel.isWrittenBy(asWriter)))
    new Counter().increment.increment.increment.increment
      .decrement(novel.authorAge).increment(Variables.any)
      .print.decrement.decrement.print
    println("playground for "+ MethodNotations.getClass)
    println("Person likes as natural language: " + (MethodNotations.me likes "Matrix"))
    println("hanging! : %s" format MethodNotations.me +
      new MethodNotations.Person(StringOperations.name, MethodNotations.me.favourite))
    println("Unary operations for !(false): " + !MethodNotations.me )
    println("postfix operations for: " .+(MethodNotations.me isAlive))
    println("apply me:" + MethodNotations.me())
    println("Unary operations for ~: " + ~MethodNotations.me)
    println("nickname: " + (MethodNotations.me + "maquinterocar")())
    println("plus me:" + +MethodNotations.me.age)
    println("me learning: ".+(MethodNotations.me learnsScala))
    println("apply me n: " + MethodNotations.me(Variables.any))

    println("playground for " + Objects.getClass)
    println("singleton comparison: " .+(Objects.mary == Objects.john))
    println("object comparison: " .+(Objects.person1 == Objects.person2))
    println("object as application: " .+(Objects.bobbie.name))

    println("playground for " + Inheritance.getClass)
    print("check inheritance: " + Inheritance.dog.creatureType + " eating  ...")
    Inheritance.dog.eat
    println("check sealed: " )
    // class anyClass extends Inheritance.UnknownAnimal
    // class anyClass extends Inheritance.Animal
    print("unknown animal is: %s -> %s ".format(
      Inheritance.unknownAnimal.getClass, Inheritance.unknownAnimal.creatureType))
    Inheritance.unknownAnimal.eat
    println("playground for " + AbstractDataTypes.getClass)
    print("check trait: ")
    AbstractDataTypes.croc.eat(AbstractDataTypes.dog)
    val list = new Consecutive(1, new Consecutive(2, new Consecutive(3, Empty)))
    println("check MyList (toString override)  %s -> %d ? %b".format(
      list, list.tail.add(4).head, list.isEmpty))
  }
}
