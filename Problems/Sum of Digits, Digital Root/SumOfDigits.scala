object SumOfDigits {
    def digitalRoot(n: Int): Int = {
        var num = n
        while (num > 9) {
            num = minimize(num)
        }
        num
    }
    
    def minimize(n: Int): Int = {
        var sum = 0
        var num = n
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        sum
    }
}
