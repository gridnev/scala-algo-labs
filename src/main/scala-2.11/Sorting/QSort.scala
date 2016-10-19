package Sorting

/**
  * Created by denver on 10/19/16.
  */
object QSort {
  def sort(list:List[Int]):List[Int]= {
    def split:(List[Int], List[Int]) = {
      def getBase = scala.util.Random.nextInt(list.size)

      val base = list(getBase)
      list.partition(_ < base)
    }

    list match {
      case Nil => list
      case x::Nil => list
      case x::xs => {
        val (left, right) = split
        sort(left) ++ sort(right)
      }
    }
  }
}
