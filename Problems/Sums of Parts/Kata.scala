object Kata {
    def partsSums(l: List[Int]): List[Int] = {
        val arr = l.toArray
        val sums = new Array[Int](arr.length + 1)
        sums(sums.length - 1) = 0

        for (i <- arr.length - 1 to 0 by -1) {
            sums(i) = sums(i + 1) + arr(i)
        }
        sums.toList
    }
}
