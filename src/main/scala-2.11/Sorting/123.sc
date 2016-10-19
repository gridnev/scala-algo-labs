List(1,2,3).splitAt(3/2)

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

def print(list:List[Item]):Unit = {
  println(list.head.key + " " + list.last.key + " " + list.head.value + " " + list.last.value)
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

    //print(res)
    println(res.mkString(" "))
    res
  }
}

MergeSorting.sort(List(1,8,2,1,4,7,3,2,3,6).zipWithIndex.map(x=>Item(x._2 + 1,x._1)))