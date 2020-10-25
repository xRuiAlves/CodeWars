object Thirteen {
    final def REMAINDERS: Array[Int] = Array(1, 10, 9, 12, 3, 4)

    def thirt(n: Long): Long = {
        var curr_n = n
        while(true) {
            val new_n = simplify(curr_n)
            if (new_n == curr_n) {
                return curr_n
            }
            curr_n = new_n
        }
        throw new Exception("Solution not found")
    }

    def simplify(n: Long): Long = {
        var i = 0
        var num = n
        var simplified: Long = 0

        while (num > 0) {
            simplified += (num % 10) * REMAINDERS(i % REMAINDERS.length).toLong
            i += 1
            num /= 10
        }

        simplified
    }
}
