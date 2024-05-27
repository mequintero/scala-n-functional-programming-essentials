package exercises

object SideEffects {
  def main(args: Array[String]): Unit = {
    val greeting = {
      val name = if (args.length > 0) args(0) else "World"
      "hello" + " " + name + "!"
      "hello%s !".format(if name == "World" then " " + name else name)
      s"Hello $name!"
    }
    println(greeting)
  }
}
