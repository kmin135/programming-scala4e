import java.io.File

def fileLines(file: File) = scala.io.Source.fromFile(file).getLines.toArray

// 파일 iterator 샘플
val filesHere = (new File("/Users/khs/IdeaProjects/programming-scala4e/src/main/scala/ch05")).listFiles()
for(file <- filesHere if file.isFile)
  println(file)

// for 절 yield 본문
// 본문을 수행할 때마다 값을 만들어 이 모든 값의 컬렉션을 생성한다.
val lineLength = for {
  file <- filesHere
  if file.isFile
  if file.getName.endsWith(".sc")
  line <- fileLines(file)
  trimmed = line.trim
} yield trimmed.length

lineLength.foreach(println)