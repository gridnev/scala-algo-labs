package Sorting

/**
  * Created by denver on 10/20/16.
  */
object BubbleSorting {
  def sort(list:List[Int]):List[Int] = {
    def inner(l: List[Int]): (List[Int], Boolean) = {
      def result(x: Int, t: (List[Int], Boolean)) = (x :: t._1, t._2)

      l match {
        case xs if xs.size < 2 => (xs, false)
        case x0 :: x1 :: xs if x0 > x1 => result(x1, (inner(x0 :: xs)._1, true))
        case x :: xs => result(x, inner(xs))
      }
    }

    inner(list) match {
      case (xs, false) => xs
      case (xs, true) => sort(xs)
    }
  }
}
