trait Philosophical {
  def philosophize() = println("I consume memory, therefore I am!")
}

/*
trait 를 믹스인할때는 extends 키워드를 사용한다.
extends 를 사용하면 트레이트의 슈퍼클래스를 암시적으로 상속한다.
 */

// Frog 는 AnyRef 의 서브클래스이며 Philosophical 를 믹스인했다.
class Frog extends Philosophical {
  override def toString = "green"
}

val frog = new Frog()
frog.philosophize()
frog

class Animal
trait HasLegs

// Pig 는 Animal의 서브클래스이며 Philosophical, HasLegs 를 믹스인했다.
class Pig extends Animal with Philosophical with HasLegs {
  override def toString = "pink"
}

val pig: Philosophical = new Pig()
pig.philosophize()
pig

/*
트레이트는 클래스를 정의하면서 할 수 있는 거의 모든 것이 가능.
문법적으로는 아래의 2가지 케이스에서 차이점이 있음.

1. 클래스 파라미터 (= 클래스의 주 생성자에 전달할 파라미터) 를 가질 수 없다.

230604 Scala 3.0 에서는 되는지 Scala 3.0 required 라고 에러메시지가 뜬다.
// trait Point(x : Int, y : Int) // compile error!

2. 클래스는 super 호출을 정적으로 바인딩하지만
트레이트는 동적으로 바인딩한다.

예를들면, 어떤 클래스에 super.toString 은 어떤 구현을 호출할지 정확히 알 수 있지만
트레이트에서는 알 수 없다. 호출할 구현은 트레이트를 클래스에 믹스인할 때마다 정해지기 때문이다.
이런 특징으로 트레이트는 변경 위에 변경을 쌓아올리는 stackable modification 이 가능하다.
*/

