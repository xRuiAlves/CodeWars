object Kata {
    def chooseBestSum(t: Int, k: Int, ls: List[Int]): Int = {
        var max = -1

        def findBest(t: Int, k: Int, ls: List[Int], curr: Int, idx: Int): Unit = {
            if (curr > t) return
            if (k == 0) {
                if (curr <= t) max = math.max(max, curr)
                return
            }

            for (i <- idx until ls.length) {
                findBest(t, k - 1, ls, curr + ls(i), i + 1)
            }
        }
        
        findBest(t, k, ls, 0, 0)
        max
    }
}
