
/*
스칼라에서 -> 메서드를 아무 객체에 대해 호출하면
해당 객체를 키로 하고 인자로 받은 다른 객체를 값으로 하는 원소가 2개인 튜플을 만듬 (implicit conversion)
타입추론이 가능하므로 타입 선언 생략가능
 */
val hangulNumberal = Map(1 -> "하나", 2 -> "둘", 3 -> "셋")
println(hangulNumberal(2))


import scala.collection.mutable
// 선언만 할 때는 타입 추론할 대상이 없으므로 명시적으로 타입 선언해줘야함
// mutable 이라 val로 선언 후 값 추가가 가능하다.
val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island")
treasureMap += (2 -> "Find big X on ground")
treasureMap += (3 -> "Dig")
println(treasureMap(2))