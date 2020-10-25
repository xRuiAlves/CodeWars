object Kata {
    def longestRepetition(s: String): (String, Int) = {
        if (s.isEmpty) return ("", 0)

        var count = 1
        var best = (s(0), 1)

        for (i <- 1 until s.length) {
            if (s(i) == s(i - 1)) {
                count += 1
                if (count > best._2) {
                    best = (s(i), count)
                }
            } else {
                count = 1
            }
        }
        (best._1.toString, best._2)
    }
}
