//package labs
import java.io.{File, PrintWriter}

import scala.io.Source

object course1_3 extends App{
  def insertionSort(seq: Array[Int]): Array[Int] = {
    val tmp = seq
    for (i <- 1 until tmp.length) {
      var j = i - 1
      while (j >= 0 && tmp(j) > tmp(j + 1)) {
        val aj = tmp(j)
        val aj1 = tmp(j + 1)
        tmp(j) = aj1
        tmp(j+1) = aj
        j = j - 1
      }
    }
    tmp
  }

  val pw = new PrintWriter(new File("smallsort.out" ))

  val lines = Source.fromFile("smallsort.in").getLines().toList

  if(lines.length == 2)
    {
      val seq = lines(1).split(" ").map(Integer.parseInt(_))
      val seqNew = insertionSort(seq)
      pw.write(seqNew.mkString(" "))
      pw.close
    }

}


