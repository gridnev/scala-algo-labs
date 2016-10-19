package labs

//package labs

import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * Created by denver on 10/10/16.
  */
object course2_3 extends App{
  var acc:Int = 0

    def sort(list:List[Int]): List[Int] = {
      def merge(left: List[Int], right: List[Int]): List[Int] = {
        (left, right) match {
          case (Nil, ys) => {ys}
          case (xs, Nil) => {xs}
          case (x :: xs, y :: ys) if x <= y => {

            x :: merge(xs, y::ys)
          }
          case (x::xs, y :: ys) => {
            acc = acc + 1;
            val h = merge(x::Nil, y::Nil)
            y :: merge(x::xs, ys)
          }
        }
      }

      list match {
        case x :: Nil => list
        case _ => {
          val (left, right) = list.splitAt(list.size / 2)
          merge(sort(left), sort(right))
        }
      }

    }

  val lines = Source.fromFile("inversions.in").getLines().toList

  if(lines.length == 2)
  {
    val seq = lines(1).split(" ").map(Integer.parseInt)
    sort(seq.toList)

    val pw = new PrintWriter(new File("inversions.out" ))
    pw.println(acc)
    pw.close
  }

}
