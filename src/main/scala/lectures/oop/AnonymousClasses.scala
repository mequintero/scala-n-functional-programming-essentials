package lectures.oop

import lectures.basics.StringOperations.name
import lectures.oop.AbstractDataTypes.Animal

object AnonymousClasses extends App {

  abstract class simpleAnimal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahaah")
  }
  /* equivalent with */
  private class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahahaah")
  }
  private val funnyAnimalAnon: Animal = new AnonymousClasses$$anon$1

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person(name) {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }

  /*
    Exercises:
    1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
    2.  Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3.  MyList:
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) => MyList[B]

        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]

        [1,2,3].map(n * 2) = [2,4,6]
        [1,2,3,4].filter(n % 2) = [2,4]
        [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
   */
}
