package lectures.basics

object Variables extends App {
  var any = 1
  any = Values.two
  println("%d length(%d)".format(any, any.toString.length))
  // variables can mutate only of value. type variables is immutable
  any = Values.x.length
  print(Values.x + s" length($any)")
}
