// s 인터폴레이션 : 각 표현식을 평가하고 결과에 toString을 호출한 다음
// 내장된 표현식을 toString의 결과로 대치
val name = "world"
s"Hello, ${name}"
// 변수 하나라면 중괄호 생략가능
s"Hello, $name"
s"The answer is ${6 * 7}"

// raw 인터폴레이션 : s와 유사하나 문자열 이스케이프 시퀀스를 인식하지 못함
// 아래는 역슬래시 4개를 그대로 출력함
raw"No\\\\escape"

// f 인터폴레이션 : printf 스타일의 형식 지정
f"${math.Pi}%.2f"
f"${7}%03d"

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

// 다른데에 복붙한다면 (SQL 이라던가) 이게 차라리 편할지도...?
println(
"""
Welcome to 123.
Type "HELP" for help
"""
)