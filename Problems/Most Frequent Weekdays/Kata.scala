import scala.collection.mutable
import java.time.{ DayOfWeek, LocalDate }

object Kata {
    final val diffs = Array(0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4)

    def getWeekDay(day: Int): String = day match {
        case 0 => "Monday"
        case 1 => "Tuesday"
        case 2 => "Wednesday"
        case 3 => "Thursday"
        case 4 => "Friday"
        case 5 => "Saturday"
        case 6 => "Sunday"
    }

    def mostFrequentDays(year: Int): List[String] = {
        var curr_day = LocalDate.of(year, 1, 1).getDayOfWeek match {
            case DayOfWeek.MONDAY => 0
            case DayOfWeek.TUESDAY => 1
            case DayOfWeek.WEDNESDAY => 2
            case DayOfWeek.THURSDAY => 3
            case DayOfWeek.FRIDAY => 4
            case DayOfWeek.SATURDAY => 5
            case DayOfWeek.SUNDAY => 6
        }
        
        val counts = new mutable.HashMap[Int, Int]().withDefaultValue(0)

        for (month <- 1 to 12; _ <- 1 to getMonthNumDays(month, year)) {
            counts(curr_day) += 1
            curr_day = (curr_day + 1) % 7
        }

        val max_count = counts.values.max
        counts.keys.filter(day => counts(day) == max_count).map(getWeekDay).toList
    }

    def getWeekDay(day: Int, month: Int, year: Int): Int = {
        val normalized_year = if (month < 3) year - 1 else year
        (year + year/4 - year/100 + year/400 + diffs(month - 1) + day) % 7
    }

    def getYearNumDays(year: Int): Int = if (isLeapYear(year)) 366 else 365

    def getMonthNumDays(month: Int, year: Int): Int = month match {
        case 1 => 31
        case 2 => if (isLeapYear(year)) 29 else 28
        case 3 => 31
        case 4 => 30
        case 5 => 31
        case 6 => 30
        case 7 => 31
        case 8 => 31
        case 9 => 30
        case 10 => 31
        case 11 => 30
        case 12 => 31
    }

    def isLeapYear(year: Int): Boolean =
        (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)
}
