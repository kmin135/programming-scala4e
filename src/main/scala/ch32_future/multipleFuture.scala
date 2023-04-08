package ch32_future

import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

object multipleFuture {
  def main(args: Array[String]): Unit = {
    val fseq = Seq(Future{Thread.sleep(100); 1},
      Future{Thread.sleep(500); 2},
      Future{Thread.sleep(600); 3},
      Future{Thread.sleep(700); 4},
      Future{Thread.sleep(800); 5})
    val list = new ListBuffer[Int]

    val futureSequence = Future.sequence(fseq)
    val seqFuture = for {
      seq <- futureSequence
    } yield {
      seq.map(s => {
        list += s
      })
    }

    Await.result(seqFuture, 1.seconds)
    println(list.toList)

    /*Future.traverse(fseq) {
      i => i
    }.map(ss => {
      ss.foreach(println)
    })
    Await.result(seqFuture, 1.seconds)*/
  }
}
