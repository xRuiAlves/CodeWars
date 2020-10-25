object Scoring {
    def high(s: String): String = {
        val words = s.split(" ")
        var best_score = getScore(words(0))
        var best_word = words(0)
        
        for (i <- 1 until words.length) {
            val score = getScore(words(i))
            if (score > best_score) {
                best_score = score
                best_word = words(i)
            }
        }
        best_word
    }
    
    def getScore(word: String): Int = word.toCharArray.map(c => c - 'a' + 1).sum
}
