//package labs
import java.io.{File, PrintWriter}
import scala.io.Source

object course1_1 extends App{

  val pw = new PrintWriter(new File("aplusb.out" ))

  for(line <- Source.fromFile("aplusb.in").getLines())
    {
      val args = line.split(' ') //filter (_.forall(x => x.isDigit || x.isSpaceChar))
      if(args.length > 1)
        pw.write((Integer.parseInt(args(0)) + Integer.parseInt(args(1))).toString)
    }
  pw.close
}


