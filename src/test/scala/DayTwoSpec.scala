import org.scalatest.FlatSpec

class DayTwoSpec extends FlatSpec {

  "The checksum" should "equal eighten" in {
    val spreadsheet = "5 1 9 5\n7 5 3\n2 4 6 8"
    val spreadsheetList = spreadsheet.split("\n").toList

    val sum = DayTwo.getCheckSum(spreadsheetList)
    assert(sum === 18)

  }
  "DayTwo.getEvenlyDivisibleCheckSum" should "return list" in {
       val spreadsheet = "5 9 2 8\n9 4 7 3\n3 8 6 5"
       val spreadsheetList = spreadsheet.split("\n").toList
       val sum = DayTwo.getEvenlyDivisibleCheckSum(spreadsheetList)
       assert(sum === 9)
     }

}
