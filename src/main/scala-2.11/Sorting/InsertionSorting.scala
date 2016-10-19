object insertionSort {
  def insertionSortReq(seq: Seq[Int])(implicit index: Int = 0): Seq[Int] = {
    def inner(seqTmp: Seq[Int], i: Int): Seq[Int] = {
      val j = i - 1
      if (j >= 0 && seqTmp(i) < seqTmp(j))
        inner(seqTmp.updated(j, seqTmp(i)).updated(i, seqTmp(j)), j)
      else
        seqTmp
    }

    if (index < seq.length - 1)
      insertionSortReq(inner(seq, index + 1))(index + 1)
    else
      seq
  }

  def insertionSort(seq: Seq[Int]): Seq[Int] = {
    var tmp = seq
    for (i <- 1 until tmp.length) {
      var j = i - 1
      while (j >= 0 && tmp(j) > tmp(j + 1)) {
        tmp = tmp.updated(j, tmp(j + 1)).updated(j + 1, tmp(j))
        j = j - 1
      }
    }

    tmp
  }
}
