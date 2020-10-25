object Kata {
    final val FRONT_VOWELS = Set('e', 'é', 'i', 'í', 'ö', 'ő', 'ü', 'ű')
    final val FRONT_SUFFIX = "nek"
    final val BACK_VOWELS = Set('a', 'á', 'o', 'ó', 'u', 'ú')
    final val BACK_SUFFIX = "nak"

    def dative(word: String): String = {
        def findLastVowel: Char = {
            for (c <- word.toCharArray.reverse) {
                if (FRONT_VOWELS.contains(c) || BACK_VOWELS.contains(c)) return c
            }
            throw new Exception("No vowel found")
        }
        val suffix = if (FRONT_VOWELS.contains(findLastVowel)) FRONT_SUFFIX else BACK_SUFFIX

        s"$word$suffix"
    }
}
