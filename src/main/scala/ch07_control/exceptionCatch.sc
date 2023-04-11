import java.io.{FileNotFoundException, FileReader, IOException}

// 발생한 예외는 패턴 매치와의 일관성을 위해 아래와 같은 형태를 채용했다.
try {
  val f = new FileReader("noExists.txt")
} catch {
  case ex: FileNotFoundException => println("Not found")
  case ex: IOException => println("그 외 IO exception")
} finally {
  // 파일 닫기 동작 등...
  // 예제가 그렇다는거고 java에 try with resource 구문이 있듯
  // 스칼라에는 load pattern이 있다. (9장)
}