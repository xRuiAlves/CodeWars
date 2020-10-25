object WeightSort {
    def orderWeight(strng: String): String = strng.split(" ").sortWith(compareWeights).mkString(" ")

    def compareWeights(w1: String, w2: String): Boolean = {
        val w1_sum = getDigitSum(w1)
        val w2_sum = getDigitSum(w2)

        if (w1_sum != w2_sum) w1_sum < w2_sum else w1 < w2
    }

    def getDigitSum(str: String): Int = {
        var sum = 0
        for (c <- str.toCharArray) sum += c - '0'
        sum
    }
}