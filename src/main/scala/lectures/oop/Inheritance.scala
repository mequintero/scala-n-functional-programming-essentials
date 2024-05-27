package lectures.oop

object Inheritance extends App {
  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"

    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //    override val creatureType = "domestic"
    // can override in the body or directly in the constructor arguments
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  // dog.eat


  // type substitution (broad: polymorphism)
  var unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  class Pet extends Animal {
    final override def eat = println("pet eat")
  }
  // 2 - use final on the entire class
  final class Bird extends Animal {
    override def eat = println("ding ding")
  }
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files
  sealed class UnknownAnimal (override val creatureType: String) extends Dog (creatureType) {
    override def eat = println("snort snort")
  }
  unknownAnimal = new UnknownAnimal(unknownAnimal.creatureType)
}
