// 컴파일러가 리턴 타입을 추론할 수 있는 상황이면 생략 가능하다.
def max(a: Int, b: Int) = {
    if (a > b) a else b
}
// 본문이 1개의 statement 라면 중괄호도 생략 가능하다.
def max2(a: Int, b: Int) = if (a > b) a else b

max(5, 1)

/*
재귀함수인 경우는 리턴타입을 필수로 명시해야한다.
필수여부와 별개로 명시하는게 명확성 측면에서 좋을 수 있으므로 상황에 맞게 사용하자.
  - IDE에서 추론된 타입을 보여주기도 하지만 깃허브에서 코드리뷰를 하는 등 그런 기능이 없는 상황에서는
    본문을 보고 리턴타입을 생각해야한다.
 */
def factorial(n: BigInt): BigInt = {
    if (n == 0)
        1
    else
        n * factorial(n - 1)
}

factorial(5)

/*
Unit은 아무것도 반환하지 않는 것으로 자바의 void 타입과 유사
결과 타입이 Unit 인 메서드는 부수 효과만을 위해 실행하는 함수다.
 */
def greet() = println("Hello, Scala")

val args = List(1, 2, 3)
// 함수를 메서드에 인자로 넘길 수 있으며 (arg: Int) => print(s"$arg ") 를 함수 리터럴이라 한다.
// 아래 문법이 생략없이 나타낸 것
args.foreach((arg: Int) => print(arg))
// arg의 타입을 컴파일러가 추론할 수 있으므로 타입 생략 가능
args.foreach(arg => print(arg))
// 함수 리터럴이 인자를 하나만 받는 문장이라면 인자에서 이름 생략 가능1
args.foreach(print)
// for 표현식
for (arg <- args) print(arg)