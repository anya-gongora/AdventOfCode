import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object DayTwo {

  def getCheckSum(lines: List[String]): Int = {
    lines.map { line =>
      val numbers = line.split("\\s+").map(_.toInt).toSeq
       numbers.max - numbers.min
    }.sum
  }

  def getEvenlyDivisibleCheckSum(lines: List[String]): Int = {
    lines.map { line =>
      val numbers = line.split("\\s+").map(_.toInt).toSeq
      val sortedList: Seq[Int] = numbers.sortWith(_ > _)

      val tuple: (Int, Int) = sortedList.combinations(2).collect {
        case Seq(a, b) if a % b == 0 => (a, b)
      }.toList.head

      tuple._1 / tuple._2
    }.sum
  }

  def getData(fileName: String): List[String] = {
    try {
      Source.fromFile(fileName, "UTF-8").getLines().toList
    } catch {
      case e: FileNotFoundException => throw new Throwable(s"Error: File $fileName not found")
      case ioe: IOException => {
        println(fileName)
        throw new Throwable(ioe)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val file = "src/day-two-input.txt"
    val linesList = getData(file)
    val checksum = getCheckSum(linesList)
    println(s"The checksum is $checksum")

    val evenlyDivisibleChecksum = getEvenlyDivisibleCheckSum(linesList)
    println(s"The evenly divisible checksum is $evenlyDivisibleChecksum")
  }
}
