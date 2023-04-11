
val arg = "salt"

/*
match는 switch의 강화판 같은 느낌이다.
match 역시 결과는 값이다.

디폴트 case는 언더바로 표시한다.
자바의 switch와 달리 어떤 상수라도 올 수 있으며 break 문이 암묵적으로 들어있다.

 */
val friend: String = arg match {
  case "salt" => "pepper"
  case "eggs" => "bacon"
  case _ => "what?"
}

println(friend)