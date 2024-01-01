package ch04_class

import scala.collection.mutable

class ChecksumAccumulator {
    private var sum = 0

    /*
    리턴타입이 Unit인 메서드는 모두 부수효과를 위해 실행되는 것이다.
    add 는 sum을 재할당하고 있다.
    부수효과만을 위해 실행되는 메서드를 프로시져라고 부른다.
     */
    def add(b: Byte): Unit = sum += b

    def checksum() = ~(sum & 0xFF) + 1
}

/*
스칼라가 자바보다 더 객체지향적인 이유 중 하나는
스칼라 클래스에는 정적멤버가 없다는 것.
대신에 스칼라는 싱글톤 객체를 제공함

어떤 싱글톤 객체의 이름이 어떤 클래스와 같을 때, 그 객체를 클래스의 동반 객체라고함. (반대 입장에서는 동반 클래스)
. 클래스와 동반 객체는 반드시 같은 소스 파일 안에 정의해야함.
. 클래스와 동반 객체는 서로의 비공개 멤버에 접근할 수 있음.
. 싱글톤 객체의 초기화는 어떤 코드가 그 객체에 처음 접근할 때 일어남.
. 동반 클래스가 없는 싱글톤 클래스를 독립 객체라 함. 독립 객체는 유틸리티 메서드를 모아둔다거나 애플리케이션 진입점으로 쓰는 등의 활용 방법이 있음.

자바 개발자라면 싱글톤 객체를 자바의 정적 메서드를 담아두는 집처럼 생각할 수도 있음.
. 다만 싱글톤은 슈퍼클래스를 확장하거나 믹스인할 수 있어 그 이상의 역할을 함. (13장 참고)
 */
object ChecksumAccumulator {
    private val cache = mutable.Map.empty[String, Int]

    def calculate(s: String): Int = {
        if (cache.contains(s))
            cache(s)
        else {
            val acc = new ChecksumAccumulator
            for (c <- s)
                acc.add(c.toByte)
            val cs = acc.checksum()
            cache += (s -> cs)
            cs
        }
    }
}