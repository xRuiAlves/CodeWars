import scala.collection.mutable

object StockList {
    def stockSummary(lstOfArt: Array[String], lstOfCat: Array[String]): String = {
        if (lstOfArt.isEmpty || lstOfCat.isEmpty) return ""
        
        val inventory = new mutable.HashMap[Char, Int]().withDefaultValue(0)

        lstOfArt.foreach(item_info => {
            val tokens = item_info.split(" ")
            val category = tokens(0)(0)
            val quantity = tokens(1).toInt
            inventory(category) += quantity
        })

        lstOfCat
            .map(category => s"($category : ${inventory(category(0))})")
            .mkString(" - ")
    }
}