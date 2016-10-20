import Sorting.QSort
import org.scalacheck.Prop.{True, forAll}
import org.scalacheck.Properties

object QSortTestSpec extends Properties("QSort") {
  property("QSort") = forAll { (s: List[Int]) =>
    isSorted(QSort.sort(s))
  }

  def isSorted(l: Seq[Int]): Boolean = {
    l match {
      case Nil => true
      case x :: Nil => true
      case x :: xs => x <= xs.head && isSorted(xs)
    }
  }
}