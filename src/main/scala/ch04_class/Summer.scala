package ch04_class

object Summer {
  // 아래와 정확히 동일한 시그니처의 메서드를 가지면 어떤 독립 객체든 애플리케이션의 시작점 역할을 할 수 있다.
  def main(args: Array[String]) = {
    for(arg <- args)
      println(s"${arg} : ${ChecksumAccumulator.calculate(arg)}")
  }

}
