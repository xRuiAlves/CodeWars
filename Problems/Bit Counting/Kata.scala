object Kata {
    def countBits(n: Int): Int = {
        var count = 0
        var num = n
        while (num > 0) {
            count += num & 1
            num >>= 1
        }
        count
    }
}
