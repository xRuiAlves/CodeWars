object Kata {
    def multiplicationTable(size: Int): List[List[Int]] = List.from((1 to size)
        .map(i => List.from(1 to size).map(j => i * j)))
}
