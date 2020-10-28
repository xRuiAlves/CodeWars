object Kata {
    def solution(s: String): List[String] = (0 until s.length by 2)
        .map(i => if (i == s.length - 1) s"${s(i)}_" else s.substring(i, i + 2))
        .toList
}
