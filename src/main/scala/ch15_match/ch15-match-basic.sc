
// 15.6 Option 에 패턴 매치 적용하기

def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
}

show(Some("option"))
show(None)

/*
15.7 독립적인 match 표현식뿐만 아니라 스칼라의 다른 곳에서도 패턴을 사용할 수 있음
 */

// 변수 정의에서 패턴사용
val myTuple = (123, "abc")
val (num, str) = myTuple
num
str

// 케이스 클래스에 적용
case class BinOp(oper: String, num1: Int, num2: Int)
val exp = BinOp("*", 5, 1)
val BinOp(op, left, right) = exp
s"$left $op $right"