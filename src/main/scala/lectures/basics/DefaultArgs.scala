package lectures.basics

object DefaultArgs {
  def factorial(n: Int, acc: BigInt = 1, printable: Boolean = false): BigInt =
    // acc *= n
    if (n <= 1) acc
    else
      if (printable)
        println("Recursion using acc for " + n + " needs calculate factorial for " + (n - 1))
      factorial(n - 1, acc * n, printable)

  val fact10 = factorial(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("saving picture in " + format + " at " + width + "x" + height + " resolution")
  // 1. pass in every leading argument
  savePicture("png",720, 360)
  // 2. name the arguments 
  savePicture() // all default arguments are used
  savePicture(width = 800) // default format and height are used   
  savePicture(height = 600, width = 800, format = "bmp")
}
