package lectures.basics

object Variables extends App {
  private var any = 1
  any = Values.two
  println(any + " length(%s)".format(any.toString.length))
  // variables can mutate only of value. type variables is immutable
  any = Values.x.length
  print(Values.x + s" length($any)")
}
