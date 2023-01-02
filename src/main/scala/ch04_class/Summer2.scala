package ch04_class

// scala.App 트레이트를 이용한 실행방법
object Summer2 extends App {
  for(season <- List("fall", "winter", "spring"))
    println(s"${season} : ${ChecksumAccumulator.calculate(season)}")
  // main 처럼 암시적으로 선언된 args를 통해 명령행 인자에 접근할 수 있음
  for(arg <- args)
    println(arg)
}
