package ch23_for_more


case class Person(name: String, isMale: Boolean, children: Person*)

object Main {
    def main(args: Array[String]): Unit = {
        val lara = Person("Lara", false)
        val bob = Person("Bob", true)
        val julie = Person("Julie", false, lara, bob)
        val persons = List(lara, bob, julie)

        val parentAndChildList: List[(String, String)] = persons filter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name))))
        println(parentAndChildList)

        // filter와 달리 withFilter는 중간 데이터 구조를 만들지 않고도 동일한 연산을 할 수 있다.
        val parentAndChildList2: List[(String, String)] = persons withFilter(p => !p.isMale) flatMap(p => (p.children map (c => (p.name, c.name))))

        println(parentAndChildList == parentAndChildList2)

        /*
        고차함수보다 for문이 더 높은 가독성을 주는 경우가 있다.
        
        스칼라 컴파일러는 아래의 for문을 parentAndChildList2 를 만들때와 동일(또는 유사)한 것으로 변환한다.
        더 일반적으로 말하면, 컴파일러는 결과를 yield 하는 모든 for 표현식을 고차 메서드(map, flatMap, withFiler, ...)를 조합한 표현식으로 변환한다.
        yield가 없는 for 표현식은 더 적은 개수의 고차함수, 즉 withFilter와 foreach 만을 사용한다.
         */
        val parentAndChildList3 = for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)

        println(parentAndChildList == parentAndChildList3)
    }
}