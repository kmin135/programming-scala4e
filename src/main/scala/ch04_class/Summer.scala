package ch04_class

object Summer {
  def main(args: Array[String]): Unit = {
    for(arg <- args)
      println(s"${arg} : ${ChecksumAccumulator.calculate(arg)}")
  }

}
