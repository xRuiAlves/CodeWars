object Kata {
    def narcissistic(n: Int): Boolean = {
        val base = n.toString.length
        var num = n
        var sum = 0

        while (num > 0 && sum < n) {
            val digit = num % 10
            sum += math.pow(digit, base).toInt
            num /= 10
        }

        sum == n
    }
}
