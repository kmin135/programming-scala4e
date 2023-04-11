
val n = 3


val half: Int = if (n % 2 == 0) n / 2 else throw new RuntimeException("n must be even")
println(half)

/*
throw 도 결과 타입이 있는 표현식이다.
위 예제에서는 n이 짝수가 아니면 어떤 값으로 초기화되기 전에 예외를 발생시킨다.
그래서 half의 타입을 Int 로 고정할 수 있다.

기술적으로는 예외는 Nothing 타입이다.
따라서 어떤 값을 만들어 내는 일은 없으나 throw를 표현식처럼 사용할 수 있다.
 */