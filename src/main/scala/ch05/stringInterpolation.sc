// s 인터폴레이션 : 각 표현식을 평가하고 결과에 toString을 호출한 다음
// 내장된 표현식을 toString의 결과로 대치
val name = "world"
s"Hello, ${name}"
s"The answer is ${6 * 7}"

// raw 인터폴레이션 : s와 유사하나 문자열 이스케이프 시퀀스를 인식하지 못함
// 아래는 역슬래시 4개를 그대로 출력함
raw"No\\\\escape"

// f 인터폴레이션 : printf 스타일의 형식 지정
f"${math.Pi}%.2f"
f"${7}%03d"

import scala.language.postfixOps
name toLowerCase