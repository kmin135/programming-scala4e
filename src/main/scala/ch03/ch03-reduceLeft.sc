val l1 = List(1)

val sum = l1.reduceLeft(_ + _)

l1.reduceLeft { (a, b) => a + b }