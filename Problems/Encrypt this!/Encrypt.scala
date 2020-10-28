object Encrypt {
    def encryptThis(text: String): String = text.length match {
        case 0 => ""
        case _ => text.split(" ").map(encryptWord).mkString(" ")
    }

    def encryptWord(word: String): String = {
        val sb = new StringBuilder
        sb.append(word(0).toInt)

        if (word.length == 2) sb.append(word.last)
        else if (word.length > 2) {
            sb.append(word.last)
            if (word.length > 2) {
                sb.append(word.substring(2, word.length - 1))
            }
            sb.append(word(1))
        }
        sb.toString
    }
}
