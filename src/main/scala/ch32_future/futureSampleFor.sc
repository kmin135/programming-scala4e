import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/*
for 식으로 Future 변환
 */

val fut1 = Future { Thread.sleep(2000); 2 + 3}
val fut2 = Future { Thread.sleep(4000); 3 + 4}
val forResult = for {
  x <- fut1
  y <- fut2
} yield x + y

forResult

Thread.sleep(2000)

forResult

Thread.sleep(2000)

forResult