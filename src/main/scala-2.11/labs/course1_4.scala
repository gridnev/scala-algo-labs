//package labs

//package labs
import java.io.{File, PrintWriter}

import scala.io.Source

object course1_4 extends App{
  def insertionSort(seq: Array[Double]): Array[Double] = {
    val tmp = new Array[Double](seq.length)
    seq.copyToArray(tmp)
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

  val pw = new PrintWriter(new File("sortland.out" ))

  val lines = Source.fromFile("sortland.in").getLines().toList

  if(lines.length == 2)
    {
      val n = lines(0).toInt
      val seq = lines(1).split(" ").map(_.toDouble)
      val seqNew = insertionSort(seq)

      val min = seqNew(0)
      val max = seqNew(n - 1)
      val avg = seqNew(n/2)

      pw.write((seq.indexOf(min) + 1) + " " + (seq.indexOf(avg) + 1) + " " + (seq.indexOf(max) + 1))
      pw.close
    }

}


