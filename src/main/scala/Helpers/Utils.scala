package Helpers

import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object Utils {
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
}
