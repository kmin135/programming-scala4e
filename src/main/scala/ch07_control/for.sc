
// i <- 1 to 5 와 같은 문법을 제너레이터라 부른다.
for(i <- 1 to 5)
  println(i)

for(i <- 1 until 5)
  println(i)

// 필터 적용
for(i <- 1 to 10 if i % 2 == 0)
  println(i)

// 중첩 iteration, 도중에 변수 바인딩도 할 수 있다.
for(
  i <- 2 to 9;
  j <- 1 to 9;
  multiply = i * j;
  separator = if (j == 9) "\n" else ", "
) {
  print(s"$multiply$separator")
}

// 중첩 iterator 중괄호 (세미콜론을 안써도 된다)
for {
  i <- 2 to 9
  j <- 1 to 9
  multiply = i * j
  separator = if (j == 9) "\n" else ", "
} {
  print(s"$multiply$separator")
}

