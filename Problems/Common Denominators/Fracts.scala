object Fracts {
    def convertFrac(lst: Array[(Long, Long)]): String = {
        if (lst.isEmpty) return ""

        val multiple = lcm(lst.map(x => x._2))
        var fractions = lst.map(fraction => (fraction._1 * (multiple / fraction._2), multiple))

        var divisor: Long = 0
        do {
            divisor = gcd(fractions(0)._2, gcd(fractions.map(fraction => fraction._1)))
            if (divisor > 1) {
                fractions = fractions.map(fraction => (fraction._1 / divisor, fraction._2 / divisor))
            }
        } while (divisor > 1)

        fractions.mkString("")
    }

    def lcm(lst: Array[Long]): Long = {
        if (lst.length == 1) return lst(0)
        
        var multiple = lcm(lst(0), lst(1))
        for (i <- 2 until lst.length) {
            multiple = lcm(multiple, lst(i))
        }
        multiple
    }

    def lcm(n1: Long, n2: Long): Long = {
        var curr = math.min(n1, n2)

        while (true) {
            if (curr % n1 == 0 && curr % n2 == 0) return curr
            else curr += 1
        }
        curr
    }

    def gcd(lst: Array[Long]): Long = {
        if (lst.length == 1) return lst(0)
        
        var divisor = gcd(lst(0), lst(1))
        for (i <- 2 until lst.length) {
            divisor = gcd(divisor, lst(i))
        }
        divisor
    }

    def gcd(n1: Long, n2: Long): Long = {
        if (n2 != 0) gcd(n2, n1 % n2)
        else n1
    }
}