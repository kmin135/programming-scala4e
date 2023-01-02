package ch03

import scala.io.Source

object printEachLineOfFile {
  def main(args: Array[String]): Unit = {
    if(args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
      val longestLine = lines.reduceLeft((a, b) => if(a.length > b.length) a else b)
      val maxWidth = widthOfLengthString(longestLine)

      for(line <- lines) {
        val numSpaces = maxWidth - widthOfLengthString(line)
        val padding = " " * numSpaces
        println(s"${padding}${line.length} | ${line}")
      }
    } else {
      Console.err.println("Please enter filename")
    }
  }

  def widthOfLengthString(s: String): Int = s.length.toString.length
}
