package ch12_trait

import ch06_functional_object.Rational

// Ordered 트레이트로 Rational 에 비교연산자를 정의.
class OrderedRational(n: Int, d: Int) extends Rational(n, d) with Ordered[OrderedRational] {
  override def compare(that: OrderedRational): Int = (this.number * that.denom) - (that.number * this.denom)
}

object OrderedRationalMain {
  def main(args: Array[String]): Unit = {
    val half = new OrderedRational(1, 2)
    val third = new OrderedRational(1, 3)
    val thrid2 = new OrderedRational(2, 6)

    println(half > third)
    println(third <= thrid2)
  }
}