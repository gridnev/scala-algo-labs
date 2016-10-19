//package labs

import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * Created by denver on 10/10/16.
  */
object course2_1 extends App{
  val pw = new PrintWriter(new File("sort.out" ))

  trait SortedItem {
    def <(that: Item):Boolean
    def >(that: Item):Boolean
    def <=(that: Item):Boolean
    val key:Int
    val value:Int
  }

  object Item{
    def apply(key:Int, value:Int):Item = new Item(key, value)
  }

  class Item(val key:Int, val value:Int) extends SortedItem {
    def <(that: Item):Boolean = {
      this.value < that.value
    }

    def <=(that: Item):Boolean = {
      this.value <= that.value
    }

    def >(that: Item):Boolean = {
      this.value > that.value
    }

    override def toString: String = value.toString
  }

  def print(list:List[Item], result:List[Item]):Unit = {
    pw.println(list.head.key + " " + list.last.key + " " + result.head.value + " " + result.last.value)
  }

  object MergeSorting {
    def sort[SortedItem](list:List[Item]): List[Item] = {
      def merge(left: List[Item], right: List[Item]): List[Item] = {
        (left, right) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs, y :: ys) if (x <= y) => x :: merge(xs, y :: ys)
          case (xs, y :: ys) => y :: merge(xs, ys)
        }
      }

      val res = list match {
        case x :: Nil => list
        case _ => {
          val (left, right) = list.splitAt(list.size / 2)
          merge(sort(left), sort(right))
        }
      }

      print(list, res)
      res
    }
  }

  val lines = Source.fromFile("sort.in").getLines().toList

  if(lines.length == 2)
  {
    val seq = lines(1).split(" ").map(Integer.parseInt)
    val seqNew = MergeSorting.sort(seq.zipWithIndex.map(z=>Item(z._2 + 1, z._1)).toList)
    pw.write(seqNew.mkString(" "))
    pw.close
  }

}
