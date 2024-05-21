package lectures.oop

object MethodNotations extends App {

  class Person (val name: String, val favourite: String, val age : Int = 0){
    def likes (movie: String) : Boolean = favourite == movie
    def hangOutWith (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person) = hangOutWith(person)
    def unary_! = s"$name is not hanging out with anyone"
    def unary_~ = s"$name is able to hang out with everyone"
    def isAlive: Boolean = true
    // apply: run Person as a method (without fix)
    def apply(): String = s"Hi, my name is $name and I like $favourite"
    // overload + operator
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favourite)
    def unary_+ : Person = new Person(name, favourite, age + 1)
    def learns (any: String) = s"$name is learning $any"
    def learnsScala = this learns "Scala"
    def apply(times: Int): String = s"$name watched $favourite $times times"
    def unary_- : Person = new Person(name, favourite, age - 1)
    def ++(person: Person): Person = new Person(s"$name and ${person.name}", favourite)

    override def toString: String = s"Person(name=$name, favourite=$favourite, age=$age)"
  }
  val me = new Person (Basics.person.name, "Matrix")
  // infix notation = operator notation (syntactic sugar)
  println(me.likes("Inception") || (me likes "Inception"))
  // operators in scala are methods
  println((me.name + " " + me.favourite).==(me.name + " Matrix") )
  // prefix notation
  val x = -1
  // equivalent to 1.unary_-
  val y = 1.unary_- // + - ~ !
  println(x == y)
  // postfix notation
  println(x.unary_- == y)
}
