import scala.collection.mutable

object Kata {
    def count(string: String): Map[Char,Int] = {
        val counts = new mutable.HashMap[Char, Int]().withDefaultValue(0)
        string.toCharArray.foreach(c => counts(c) += 1)
        counts.toMap
    }
}