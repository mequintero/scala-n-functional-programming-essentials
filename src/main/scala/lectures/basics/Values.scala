package lectures.basics

object Values extends App {
//  val: inmutable
private val one = 1
//  compiler can infer types
  val x = ("one: " + one )
  println(x + " ("+one.getClass+")")
  val two: Int = 2
//  println("two: " + two )
  val three: String = 3.toString
//  println("three: " + three)
  val four = "%s".format(4)
  println("four: ("+four.getClass.getSimpleName+")")
  val five = four.nonEmpty
  println("five: ("+five.getClass.getName+")")
  val six: Boolean = five.equals(false)
//  println("six: " + six)
  val seven: Char = six.toString.charAt(0)
  println("seven: ("+seven.getClass.getName+")")
  val eight: Int = seven.byteValue.toInt
  println("eight: ("+eight.getClass+")")
  val nine: Short = eight.toShort
  println("nine: ("+nine.getClass.getName+")")
  val ten: Long = 102L
  println("ten: ("+ten.getClass.getName+") == nine.toLong is " + (nine.toLong == ten))
  val eleven: Float = 102.0f
  println("eleven: ("+eleven.getClass.getName+") == ten.toFloat is " + (ten.toFloat == eleven))
  val twelve: Double = 102.0
  println("twelve: ("+twelve.getClass.getName+") == eleven.toDouble is " + (eleven.toDouble == twelve))
}
