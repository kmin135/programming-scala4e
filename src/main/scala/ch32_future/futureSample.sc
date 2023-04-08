import scala.concurrent.Future

// Future 실행을 위해 전역 실행 컨텍스트 임포트
// JVM 에서 전역 실행 컨텍스트는 스레드풀을 사용함
import scala.concurrent.ExecutionContext.Implicits.global

val fut = Future { Thread.sleep(2000); 1 + 1}
fut.isCompleted
fut.value

Thread.sleep(2000)

fut.isCompleted
fut.value

val fut = Future { Thread.sleep(2000); 1 / 0}
Thread.sleep(2000)
fut.isCompleted
fut.value

/*
map으로 Future 이어서 계산하기
퓨처 생성, 1+1 계산, 2+1 계산이 각기 다른 세 개의 스레드에서 실행됨
 */
val fut = Future { Thread.sleep(2000); 1 + 1}
val incr = fut.map(x => x+1)

Thread.sleep(2000)

fut.isCompleted
fut.value
incr.isCompleted
incr.value