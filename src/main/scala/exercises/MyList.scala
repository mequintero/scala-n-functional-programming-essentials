package exercises

abstract class MyList {
  def head : Int

  def tail : MyList

  def isEmpty : Boolean

  def add(element : Int) : MyList
  // methods must be public for extension calling
  def printElements : String

  // polymorphic call
  override def toString: String = s"[$printElements]"
}


object Empty extends MyList {
  def head = throw new NoSuchElementException

  def tail = throw new NoSuchElementException

  def isEmpty = true

  def add(element : Int) = new Consecutive(element, Empty)

  def printElements = new String()
}

class Consecutive(h : Int, t : MyList) extends MyList {
  def head = h

  def tail = t

  def isEmpty = false

  def add(element : Int): MyList = new Consecutive(element, this)

  def printElements : String = {
    // printElements must be public for extension calling
    if (t.isEmpty) h.toString else h + " " + t.printElements
  }
}


/* Generic abstract class */
abstract class ListA[+A] {
  def head: A

  def tail: ListA[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): ListA[B]

  def printElements: String

  override def toString: String = "[%s]".format(printElements)

  // higher-order functions
  def map[B](transformer: A => B): ListA[B]

  def flatMap[B](transformer: A => ListA[B]): ListA[B]

  def filter(predicate: A => Boolean): ListA[A]

  // concatenation
  def ++[B >: A](list: ListA[B]): ListA[B]

  // higher order functions
  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): ListA[A]

  def zipWith[B, C](list: ListA[B], zip: (A, B) => C): ListA[C]

  def fold[B](start: B)(operator: (B, A) => B): B

  def reverse: ListA[A] = {
    def reverseTailrec(input: ListA[A], result: ListA[A]): ListA[A] =
      if (input.isEmpty) result
      else reverseTailrec(input.tail, ConsecutiveList(input.head, result))

    reverseTailrec(this, EmptyList)
  }
}


object EmptyList extends ListA[Nothing] {

  def head: Nothing = throw new NoSuchElementException

  def tail: ListA[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): ListA[B] = new ConsecutiveList(element, EmptyList)

  def printElements: String = new String()

  def map[B](transformer: Nothing => B): ListA[B] = EmptyList

  def flatMap[B](transformer: Nothing => ListA[B]): ListA[B] = EmptyList

  def filter(predicate: Nothing => Boolean): ListA[Nothing] = EmptyList

  def ++[B >: Nothing](list: ListA[B]): ListA[B] = list

  // higher order functions
  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = EmptyList

  def zipWith[B, C](list: ListA[B], zip: (Nothing, B) => C): ListA[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else EmptyList

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}


class ConsecutiveList[+A](h: A, t: ListA[A]) extends ListA[A]:
  def head = h

  def tail = t

  def isEmpty = false

  def add[B >: A](element: B): ListA[B] = new ConsecutiveList(element, this)

  def printElements = if (t.isEmpty) h.toString else "%s %s".format(h, t.printElements)

  def map[B](transformer: A => B): ListA[B] = ???

  def flatMap[B](transformer: A => ListA[B]): ListA[B] = ???

  def filter(predicate: A => Boolean): ListA[A] = ???

  def ++[B >: A](list: ListA[B]): ListA[B] = ???

  def foreach(f: A => Unit): Unit = ???

  def sort(compare: (A, A) => Int): ListA[A] = ???

  def zipWith[B, C](list: ListA[B], zip: (A, B) => C): ListA[C] = ???

  def fold[B](start: B)(operator: (B, A) => B): B = ???


case class ConsecutiveCase[+A](h: A, t: ListA[A]) extends ListA[A] {
    def head: A = h

    def tail: ListA[A] = t

    def isEmpty: Boolean = false

    def add[B >: A](element: B): ListA[B] = ConsecutiveCase(element, this)

    def printElements: String =
      if (t.isEmpty) "" + h
      else s"$h ${t.printElements}"

    /*
      [1,2,3].filter(n % 2 == 0) =
        [2,3].filter(n % 2 == 0) =
        = new ConsecutiveCase(2, [3].filter(n % 2 == 0))
        = new ConsecutiveCase(2, Empty.filter(n % 2 == 0))
        = new ConsecutiveCase(2, Empty)
     */
    def filter(predicate: A => Boolean): ListA[A] =
      if (predicate(h)) new ConsecutiveCase(h, t.filter(predicate))
      else t.filter(predicate)

    /*
      [1,2,3].map(n * 2)
        = new ConsecutiveCase(2, [2,3].map(n * 2))
        = new ConsecutiveCase(2, new ConsecutiveCase(4, [3].map(n * 2)))
        = new ConsecutiveCase(2, new ConsecutiveCase(4, new ConsecutiveCase(6, Empty.map(n * 2))))
        = new ConsecutiveCase(2, new ConsecutiveCase(4, new ConsecutiveCase(6, Empty))))
     */
    def map[B](transformer: A => B): ListA[B] =
      new ConsecutiveCase(transformer(h), t.map(transformer))

    /*
      [1,2] ++ [3,4,5]
      = new ConsecutiveCase(1, [2] ++ [3,4,5])
      = new ConsecutiveCase(1, new ConsecutiveCase(2, Empty ++ [3,4,5]))
      = new ConsecutiveCase(1, new ConsecutiveCase(2, new ConsecutiveCase(3, new ConsecutiveCase(4, new ConsecutiveCase(5)))))
     */
    def ++[B >: A](list: ListA[B]): ListA[B] = new ConsecutiveCase(h, t ++ list)

    /*
      [1,2].flatMap(n => [n, n+1])
      = [1,2] ++ [2].flatMap(n => [n, n+1])
      = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
      = [1,2] ++ [2,3] ++ Empty
      = [1,2,2,3]
     */
    def flatMap[B](transformer: A => ListA[B]): ListA[B] =
      transformer(h) ++ t.flatMap(transformer)

    // hofs
    def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
    }

    def sort(compare: (A, A) => Int): ListA[A] = {
      def insert(x: A, sortedList: ListA[A]): ListA[A] =
        if (sortedList.isEmpty) new ConsecutiveCase(x, EmptyList)
        else if (compare(x, sortedList.head) <= 0) new ConsecutiveCase(x, sortedList)
        else new ConsecutiveCase(sortedList.head, insert(x, sortedList.tail))

      val sortedTail = t.sort(compare)
      insert(h, sortedTail)
    }

    def zipWith[B, C](list: ListA[B], zip: (A, B) => C): ListA[C] =
      if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else new ConsecutiveCase(zip(h, list.head), t.zipWith(list.tail, zip))

    /*
      [1,2,3].fold(0)(+) =
      = [2,3].fold(1)(+) =
      = [3].fold(3)(+) =
      = [].fold(6)(+)
      = 6
     */
    def fold[B](start: B)(operator: (B, A) => B): B =
      t.fold(operator(start, h))(operator)

  }