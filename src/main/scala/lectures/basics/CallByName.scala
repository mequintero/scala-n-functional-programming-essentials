package lectures.basics

object CallByName extends App {
  // pass expression into parameter(s) (like arCall-by-Name and Call-by-Valuerow function)
  // - value evaluated each time that parameter name is used
  def calledByName(x: => Long): Unit = {
    println("by name: %d".format(x))
    println(s"by name: $x")
  }
  calledByName(System.nanoTime())
  def printFirst(x: Int, y: => Int): Unit = println(x)
  //  printFirst(infinite(), 34) // stack overflow
  // y is a function (not a value) never used
  printFirst(34, CallByValue.infinite())
}
