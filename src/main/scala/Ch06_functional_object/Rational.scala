package Ch06_functional_object

/**
 * 여기서 n, d를 클래스 파라미터라 부름
 * 컴파일러는 클래스 파라미터 정보를 통해 두 인자를 받는 주 생성자를 생성함
 */
class Rational(n: Int, d: Int) {
  // 컴파일러는 클래스 내부에 있으면서 필드나 메서드 정의에 들어있지 않은 코드를 주 생성자 내부로 밀어 넣는다.
//  println(s"$n $d")
  require(d != 0)
  val number: Int = n
  val denom: Int = d
  override def toString: String = s"$n/$d"

  def add(that: Rational): Rational = new Rational(number * that.denom + that.number * denom, denom * that.denom)
}

object RationalTest {
  def main(args: Array[String]): Unit = {
    val oneHalf = new Rational(1,2)
    val twoThirds = new Rational(2,3)
    println(oneHalf add twoThirds)

    // try divide by 0
    println(new Rational(3,0))
  }

}
