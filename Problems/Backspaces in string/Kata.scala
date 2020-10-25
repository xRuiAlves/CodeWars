import scala.collection.mutable

object Kata {
    final val BACKSPACE = '#'

    def cleanString(s: String): String = {
        val stack = new mutable.Stack[Char]()

        for (c <- s.toCharArray) {
            if (c != BACKSPACE) stack.push(c)
            else if (stack.nonEmpty) stack.pop
        }
        stack.reverse.mkString("")
    }
}
