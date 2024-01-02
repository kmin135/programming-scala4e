package ch04_class

// scala.App 트레이트를 이용한 실행방법
object Summer2 extends App {
  for(season <- List("fall", "winter", "spring"))
    println(s"${season} : ${ChecksumAccumulator.calculate(season)}")
  // App 트레이트에 있는 args를 통해 명령행 인자에 접근할 수 있음
  for(arg <- args)
    println(arg)
}
