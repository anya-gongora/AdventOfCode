import Helpers.Utils

object DayFour {

  def countValidPassPhrases(lines: Seq[String]): Int = {
   val result: Seq[Option[String]] = lines.map { line =>
      val passphrases = line.split("\\s+").toSeq
      if(passphrases.toSet.size == passphrases.size) {
        Some(line)
      } else {
        None
      }
    }

    result.count(x => x.nonEmpty)
  }

  def countUniquePassphrases(lines: Seq[String]): Int = {
    val badPhrases: Seq[Option[String]] = lines.map { line =>
      val passphrasesSeq = line.split("\\s+").toSeq
      val sortedPassphrases: Seq[String] = passphrasesSeq.map(phrase => {
         phrase.toCharArray.toSeq.sorted.mkString("")
      })

    val hasBadPhrase = sortedPassphrases.combinations(2).collect {
       case Seq(a, b) if b.contains(a)=> true
       case _ => false
     }.toSet

      if(hasBadPhrase.contains(true)) {
        None
      } else {
        Some(line)
      }
    }
    badPhrases.count(x => x.nonEmpty)
  }

  def main(args: Array[String]): Unit = {
    val file = "src/day-four-input.txt"
    val lines = Utils.getData(file)

    val countPartOne = countValidPassPhrases(lines)

    val countPartTwo = countUniquePassphrases(lines)

    println("---- Part 1 ----")
    println(s"The total valid passphrases is: $countPartOne")

    println("---- Part 2 ----")
    println(s"The total unique valid passphrases is: $countPartTwo")
  }

}
