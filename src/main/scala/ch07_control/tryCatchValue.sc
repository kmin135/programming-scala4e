import java.net.{MalformedURLException, URL}

/*
try 문도 결과는 값이다.
예외가 발생하지 않으면 try 절의 결과
예외가 발생하면 catch 절의 수행 결과

finally 절에 결과값이 있다면 버려진다.
애초에 finally는 정리 작업을 위한 것으로 결과에 관여하지 않는 것이 좋다.
 */
def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException => new URL("http://www.scala-lang.org")
  }

urlFor("https://google.com")
urlFor("not url")