import scala.util.control.Breaks.{break, breakable}

/*
break를 쓰는 것도 가능하다.
하지만 보통 이런 경우는 var를 쓰는 습관때문에 발생하며
val을 사용하고 루프 대신 재귀 스타일로 코드를 짜는 등의 습관을 들이면 break 없이도 코드를 짤 수 있다.
 */
breakable {
  for (i <- 1 to 10) {
    if(i == 3) break
    println(i)
  }
}