def removeDuplicates[A](xs: List[A]): List[A] = {
    if (xs.isEmpty) xs
    else
        xs.head :: removeDuplicates(
            xs.tail filter (x => x != xs.head)
        )
}

def removeDuplicates2[A](xs: List[A]): List[A] = {
    if (xs.isEmpty) xs
    else
        xs.head :: removeDuplicates2(
            for (x <- xs.tail; if x != xs.head) yield x
        )
}


val list = List("A", "B", "A", "C", "B", "D")

removeDuplicates(list)
removeDuplicates2(list)
list.distinct