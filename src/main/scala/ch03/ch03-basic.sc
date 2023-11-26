/*
스칼라는 배열부터 수식에 이르는 모든 것을 메서드가 있는 개체로 다룬다.
이를 통해 개념을 단순화한다.

이런 균일성에도 큰 성능상 비용이 들지 않는데
스칼라 컴파일러가 컴파일한 코드에서 가능하면 자바 배열, 원시 타입, 네이티브 연산을 사용하기 때문이다.
 */


/*
. 메서드가 한 개의 파라미터만 필요한 경우, 점(.)과 괄호 없이 호출할 수 있다.

0 to 2 는 (0).to(2) 라는 일반적인 메서드 호출로 변경된다.
(0).to(2) 는 Range 객체를 만들어낼 것이고
for 표현식을 통해 Range 를 순회한다.
 */
for (i <- 0 to 2)
    println(s"greeting $i")

// 둘은 동일하다.
// 스칼라에서는 모든 연산자가 메서드 호출이다.
1 + 2
(1).+(2)


/*
점(.)과 괄호 생략은 호출 대상 객체를 명시적으로 지정할 때만 가능하다.
그래서 아래와 같은 차이가 생긴다.
 */
//println "이건 안됨"
Console println "이건 됨"

/*
apply

변수 뒤에 하나 이상의 값을 괄호로 둘러싸서 호출하면
스칼라는 그 코드를 변수에 대해 apply라는 메서드를 호출한 것으로 바꾼다.
 */
val arr = new Array[String](2)

/*
변수 뒤에 괄호로 둘러싼 인자들이 있는 표현식에 할당을 하면
컴파일러가 update 메서드 호출로 변경한다.
 */
arr(0) = "a"
arr.update(1, "b")

for (i <- 0 to arr.length - 1) {
    // 둘은 동일하다.
    print(arr(i))
    print(arr.apply(i))
}

/*
동반객체 Array에 존재하는 apply라는 이름의 팩토리 메서드를 호출하는 것.
(= 자바의 Array라는 클래스의 정적 메서드를 호출하는 것과 유사한 것)
 */
val arr2 = Array("동", "반", "객", "체")
val arr2Verbose = Array.apply("동", "반", "객", "체")

arr2.mkString == arr2Verbose.mkString

/*
함수형 스타일
 */

val args = Array("arg1", "arg2")

// 명령형 스타일의 고전적 방식
def printArgs1(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
        println(args(i))
        i += 1
    }
}

// 함수 리터럴을 사용하면서 최대한 축약한 방식
def printArgs2(args: Array[String]): Unit = {
    args.foreach(println)
}
printArgs2(args)

/*
하지만 printArgs2 도 함수형은 아닌데 리턴타입이 Unit인 것에서도 알 수 있듯
부수효과가 있기 때문이다. 여기서는 표준출력에 파라미터를 쓰는게 부수효과다.
이렇게 되면 테스트가 어렵다.

반면 formatArgs 는 아무런 부수효과가 없다. 입력과 출력이 명확하여 테스트가 용이하다.
부수효과에 해당하는 출력코드는 별도로 작성했다.
이런 방식을 사용하면 부수효과가 있는 코드를 별도로 격리하기가 좋다.
 */
def formatArgs(args: Array[String]): String = args.mkString("\n")
assert(formatArgs(args) == "arg1\narg2")
print(formatArgs(args))

/*
var나 부수 효과가 근본적으로 나쁜건 아니다. 이역시 스칼라가 제공하는 도구다.
그러나 아래의 방식을 권장한다.

1. val, 변경 불가능한 객체, 부수 효과가 없는 메서드를 더 많이 사용하라.
2. var, 변경 가능 객체, 부수 효과가 있는 메서드는 구체적인 필요성이 있고 그 이유를 정당화할 수 있을 때 사용하라.
 */