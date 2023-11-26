import scala.collection.mutable.ListBuffer

val twoThree = List(2, 3)
/*
:: 를 콘즈 연산자라 한다.
메서드 이름이 콜론으로 끝나면 연산자 방식으로 사용 시
오른쪽 피연산자에 대해 호출을 한다.
그래서 아래 표현은 동일하다.
 */
val oneTwoThree = 1 :: twoThree
val oneTwoThree2 = twoThree.::(1)
println(oneTwoThree)
println(oneTwoThree2)

/*
콘즈 연산자만으로 리스트를 초기화할 때
1 :: 2 만으로는 초기화가 안 되는데
Int 형에는 :: 연산자가 없기 때문이다.
Nil 은 해당 연산자가 있다.
 */
val li1 = 1 :: 2 :: Nil

/*
:: 는 리스트의 맨 앞 (head)에 원소를 추가하는 O(1) 연산이다.
:+ 는 원소의 맨 뒤에 붙이는데 스칼라 리스트 구조상 O(n) 연산이다.
맨 뒤에 붙이는 연산을 빠르게 하고 싶으면 ListBuffer 를 사용해야한다.
 */
val slow = li1 :+ 3
val fast = ListBuffer(1, 2).addOne(3).toList