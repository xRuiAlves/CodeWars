object MultiplesOf3Or5 {
    def solution(number: Int): Long = {
        if (number <= 0) return 0

        var sum: Long = 0
        for (n <- 1 until number) {
            sum += (if (isMultiple(n, 3) || isMultiple(n, 5)) n else 0)
        }
        sum
    }

    def isMultiple(n: Int, base: Int): Boolean = n % base == 0
}
