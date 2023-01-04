/*
로(raw) 문자열 문법
""" 로 둘러쌈
Java도 15부터 생겼음
*/

// 공백문자까지 출력되버림
println("""Welcome to 123.
           Type "HELP" for help """)

// 파이프문자를 각 줄의 시작에 넣고 stripMargin 을 호출하여 원치않은 공백을 제거할 수 있음
println("""|Welcome to 123.
           |Type "HELP" for help""".stripMargin)