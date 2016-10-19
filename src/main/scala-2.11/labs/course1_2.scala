//package labs
import java.io.{File, PrintWriter}

import scala.io.Source

object course1_2 extends App{



  val line = Source.fromFile("aplusbb.in").getLines().toArray
  if(line.length > 0)
    {
      val pw = new PrintWriter(new File("aplusbb.out" ))
      val args = line(0).split(' ')

      if(args.length > 1){
        val r = math.BigInt(args(0)) + math.BigInt(args(1)) * math.BigInt(args(1))
        pw.write("%d".format(r))
      }

      pw.close
    }
}


