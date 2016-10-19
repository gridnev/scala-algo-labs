//package labs

import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * Created by denver on 10/10/16.
  */
object course2_2 extends App {
  val sb = StringBuilder.newBuilder
  var lastCountry = ""
  Source.fromFile("race.in").getLines().toList.tail
    .map(x => {
      val spl = x.split(" ")
      (spl(0), spl(1))
    })
    .sortBy(_._1)
    .foreach(p => {
      if (lastCountry != p._1) {
        sb.append("=== " + p._1 + " ===\n")
        lastCountry = p._1
      }
      sb.append(p._2 + "\n")
    })

  val pw = new PrintWriter(new File("race.out"))
  pw.write(sb.toString)
  pw.close
}
