package ch21_implicit



object OrderingSample {
    def maxListParm[T](elements: List[T])(implicit ordering: Ordering[T]): T = elements match {
        case List() => throw new IllegalArgumentException("empty list")
        case List(x) => x
        case x :: rest =>
            val maxRest = maxListParm(rest)(ordering)
            if (ordering.gt(x, maxRest)) x else maxRest
    }
    def main(args: Array[String]): Unit = {
        println(maxListParm(List(5,10,2)))
        println(maxListParm(List('c', 'b', 'a')))
    }
}
