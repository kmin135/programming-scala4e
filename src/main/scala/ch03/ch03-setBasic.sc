/*
기본 Set은 불변. (scala.collection.immutable 의 구현을 사용)
그래서 += 를 하면 새로운 엘리먼트가 추가된 새로운 set을 반환하므로
var로 선언해줘야 함
 */
var immutableSet = Set("a", "b")
immutableSet += "c"
println(immutableSet.contains("c"))

/*
변경가능 set은 별도 선언 필요
set 자체를 변경하므로 val 이어도 됨
 */
import scala.collection.mutable
val mutableSet = mutable.Set(1, 2)
mutableSet += 3
println(mutableSet)

/*
디폴트 Set이 아닌 명시적으로 특정 구현을 지정하려면
필요한 클래스를 임포트하고 해당 클래스에 대한 동반 객체의
팩토리 메서드를 사용 (디폴트가 hashSet이긴 함)
 */
import scala.collection.immutable.HashSet
val hashSet = HashSet("T", "C")
println(hashSet)