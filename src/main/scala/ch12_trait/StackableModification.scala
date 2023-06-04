package ch12_trait

import scala.collection.mutable.ArrayBuffer


abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  private val queue = new ArrayBuffer[Int]
  override def get(): Int = queue.remove(0)

  override def put(x: Int): Unit = {
    queue += x
  }
}

/*
abstract override 메서드가 어떤 트레이트에 있다면,
그 트레이트는 반드시 abstract override 가 붙은 메서드에 대한 구체적 구현을 제공하는
클래스에 믹스인해야한다.
 */
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = {
    super.put(x * 2)
  }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = {
    super.put(x + 1)
  }
}

object StackableModification {
  def main(args: Array[String]): Unit = {
    val queue = new BasicIntQueue
    queue.put(1)
    queue.put(2)
    println(queue.get())
    println(queue.get())

    // 믹스인 순서는 간단히 설명하면 오른쪽부터 적용한다.
    // [1,2] -> [2,4] -> [3,5]
    val q2 = (new BasicIntQueue with Incrementing with Doubling)
    q2.put(1)
    q2.put(2)
    println(q2.get())
    println(q2.get())

    // [1,2] -> [2,3] -> [4,6]
    val q3 = (new BasicIntQueue with Doubling with Incrementing)
    q3.put(1)
    q3.put(2)
    println(q3.get())
    println(q3.get())
  }
}
