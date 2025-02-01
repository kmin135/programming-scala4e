package ch08_function_closure

import scala.io.Source

object LongLines {
    def processFile(filename: String, width: Int) = {
        def processLine(line: String) = {
            if (line.length > width)
                println(filename + ": " + line.trim)
        }

        val source = Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(line)
    }
}

// ex) FindLongLines 45 src/main/scala/ch08_function_closure/LongLines.scala
object FindLongLines {
    def main(args: Array[String]): Unit = {
        val width = args(0).toInt
        for (arg <- args.drop(1)) {
            LongLines.processFile(arg, width)
        }
    }
}
