package lectures.basics

object CallByValue extends App {
  // retrieve Value of argument(s)
  // - parameter value
  def calledByValue(x: Long): Unit = {
    println("by value: %d".format(x))
    println(s"by value: $x")
  }
  calledByValue(1257387745764245L)
  def infinite(): Int = 1 + infinite()
}
