package lectures.basics

object Expressions extends App{
  val x = 1 + Values.two // Expression
  println(Values.two + x * (x+1))
  // + - * /
  val y = 1 - Values.three.toInt
  val z = Values.four.toInt / x
  // & | ^
  val a = z ^ y
  val b = Values.five & Values.six
  val c = b | Values.six
  // << >>
  val d = a << 1
  val e = a >> d
  // >>> (right shift with sign extension)
  val f = a >>> 1
  // >>> (right shift with zero extension)
  val g = f >>> 0
  // ==!= < <= > >=
  val h = a == f
  val i = a != z
  val j = a < y
  val k = x <= y
  val l = y > a
  val m = a >= x
  // && ||
  val n = c && b
  val o = c || b
  val p = !o
  var q = g
  q += Variables.any
  // also works with -= *= /= ..... side effects
  var r = q
  r -= f
  var s = r
  s *= a
  var t = s
  t /= d
  var u = t
  u %= e
  var v = u
  v <<= 1
  var w = v
  w >>= 1
  // Instructions (Execute: Action) vs Expressions (Evaluate: Value)
  val conditionValue = if (b) "yes" else "no"
  println(if (b) a else x)
  var iterations = 3
  // NEVER WRITE THIS AGAIN. (while and other loop Units are considered bad practice)
  val loop = while (iterations > 0) {
    println(iterations)
    iterations -= 1
  }
  // EVERYTHING in Scala is an Expression!
  val anUnit = (q = 0)
  println("anUnit is " + anUnit)
  val otherUnit = s = r; q = s
  println("otherUnit is " + otherUnit)
  val anotherUnit = r = q
  println("anotherUnit is " + anotherUnit)
  val lastUnit: Unit = otherUnit
  println("lastUnit is " + lastUnit)
  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val x = 1
    println(x = 4)
    var y = if (x > 4) 2 else 3
    y += 1
    y
    x
  }
  // 1. difference between "hello world" vs println("hello world")?
  val hello = {
    print("hello")
    val x = "World"
    print(if (x.length < 0) "!" else " ")
    x
  }
  val helloWorld: Unit = println {
    hello
  }
  val greeting = {
    if (helloWorld.getClass.getSimpleName.equals("String")) helloWorld
    "hello!"
  }
  println(greeting)
}
