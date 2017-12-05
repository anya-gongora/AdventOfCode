import org.scalatest.{FlatSpec, Matchers}

class DayFourSpec extends FlatSpec with Matchers {

  "DayFour.countValidPassPhrases" should "return 3" in {
    val lines =
      "aa bb cc dd ee\n aa bb cc dd aa\n aa bb cc dd aaa\n aaa bbb cc dd a\n aaa bb cc ddd aaa"

    val listOfLines = lines.split("\n").toSeq

    val count = DayFour.countValidPassPhrases(listOfLines)
    count shouldEqual 3
  }

  "DayFour.countUniquePassphrases" should "return 2" in {
    val lines =
      "abcde fghij\nabcde xyz ecdaba\niiii oiii ooii oooi oooo\noiii ioii iioi iiio"

    val listOfLines = lines.split("\n").toSeq

    val count = DayFour.countUniquePassphrases(listOfLines)
    count shouldEqual 2
  }
}
