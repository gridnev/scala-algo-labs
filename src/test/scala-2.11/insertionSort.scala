import org.scalacheck.Prop.{True, forAll}
import org.scalacheck.Properties

object TestSpec extends Properties("insertionSort") {
  property("insertionSort") = forAll { (s: List[Int]) =>
    isSorted(insertionSort.insertionSort(s))
  }

  property("insertionSortReq") = forAll { (s: List[Int]) =>
    isSorted(insertionSort.insertionSortReq(s))
  }

  property("insertionSortEq") = forAll { (s: List[Int]) =>
    insertionSort.insertionSortReq(s) == insertionSort.insertionSort(s)
  }

  def isSorted(l: Seq[Int]): Boolean = {
    l match {
      case Nil => true
      case x :: Nil => true
      case x :: xs => x <= xs.head && isSorted(xs)
    }
  }
}