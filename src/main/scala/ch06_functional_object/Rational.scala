package ch06_functional_object

// n, d를 클래스 파라미터라 함
// 스칼라 컴파일러가 클래스 파라미터를 종합해 주 생성자를 만들어줌
class Rational(n: Int, d: Int) {
  /*
   클래스 내부에 있으면서 필드나 메서드 정의에 들어 있지 않은 코드는 주 생성자로 들어간다.
   즉, 생성자가 호출될 때마다 이 코드들도 실행된다.

   require 메서드는 선결조건을 표현하기에 좋다.
   조건을 만족하지 못 하면 IllegalArgumentException 이 발생한다.
   */
  require(d != 0, "분모는 0이 될 수 없습니다.")
  println(s"In Primary Constructor : Created $n/$d")

  private val g = gcd(n.abs, d.abs)
  val number: Int = n / g
  val denom: Int = d / g

  override def toString: String = s"$number/$denom"

  // 보조 생성자. 모든 보조 생성자의 첫 구문은 this(...) 여야 한다.
  // 결과적으로 모든 보조생성자는 주 생성자를 호출하게 된다.
  // 또한 주 생성자만이 슈퍼클래스의 생성자를 호출할 수 있다.
  def this(n: Int) = this(n, 1)

  // 일반적인 영문, 숫자 조합의 식별자
  def add(that: Rational): Rational =
    new Rational(number * that.denom + that.number * denom, denom * that.denom)
  // 연산자 식별자 (하나 이상의 연산자 문자로 구성)
  def +(that: Rational) = this.add(that)
  // 메서드 오버로드
  def +(i: Int) = new Rational(number + i * denom, denom)

  def *(that: Rational) = new Rational(number * that.number, denom * that.denom)
  def *(i: Int) = new Rational(number * i, denom)
  def lessThan(that: Rational): Boolean =
    this.number * that.denom < that.number * this.denom
  def max(that: Rational): Rational =
    if(this.lessThan(that)) that else this

  // 최대공약수
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object RationalMain {
  def main(args: Array[String]): Unit = {
    val r1 = new Rational(1, 2)
    val r2 = new Rational(1, 3)
    println(s"더하기1 ${r1.add(r2)}")
    println(s"더하기2 ${r1 + r2}")
    println(s"더하기3 ${r1.+(r2)}")
    println(s"더하기4 ${r1 + 1}")

    println(r1.lessThan(r2))
    println(r1.max(r2))

    val r3 = new Rational(5)
    println(r3)
    println(s"22/44 -> ${new Rational(22, 44)}")
    println(s"곱하기1 ${r1 * r2}")

    // Int 에는 Rational 을 곱하는 * 메서드가 없으므로 호출 불가
    //    println(2 * r2)

    // 암시적 타입 변환을 이용하면 컴파일러가 변환 메서드를 사용해 자동으로 변환해준다.
    // 암시적 타입 변환이 동작하려면 해당 스코프 안에 변환 메서드가 존재해야한다.
    implicit def intToRational(x: Int) = new Rational(x)
    println(2 * r2)
  }
}
