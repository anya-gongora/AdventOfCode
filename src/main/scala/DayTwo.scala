import java.io.{FileNotFoundException, IOException}

import Helpers.Utils

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


  def main(args: Array[String]): Unit = {
    val file = "src/day-two-input.txt"
    val linesList = Utils.getData(file)
    val checksum = getCheckSum(linesList)
    println(s"The checksum is $checksum")

    val evenlyDivisibleChecksum = getEvenlyDivisibleCheckSum(linesList)
    println(s"The evenly divisible checksum is $evenlyDivisibleChecksum")
  }
}
