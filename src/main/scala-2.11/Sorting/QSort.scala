package Sorting
import scala.util._

/**
  * Created by denver on 10/19/16.
  */
object QSort {
  def sort(list: List[Int]): List[Int] =
    if (list.size < 2)
      list
    else {
      val base = list(Random.nextInt(list.size))
      sort(list.filter(_ < base)) ++
        list.filter(_ == base) ++
        sort(list.filter(_ > base))
    }
}
