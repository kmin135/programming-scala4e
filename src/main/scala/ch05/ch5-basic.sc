import scala.language.postfixOps

/*
스칼라에서 연산자는 메서드다
모든 메서드는 연산자가 될 수 있다.
s.indexOf('o') 라고 쓰면 indexOf는 연산자가 아니고
s indexOf 'o' 라고 쓰면 indexOf는 연산자다.
*/

// 아래는 동일하다. 연산자 표기를 사용했을 때는 모두 중위 연산자임을 알 수 있다.
1 + 2   // 연산자
1.+(2)  // 메서드
// Int 에는 파라미터 타입에 따라 오버로드된 +가 여럿있어 이처럼 Long타입도 받을 수 있다.
1 + 2L

val s = "Hello, World"
s.indexOf('o')
s indexOf 'o'
// 인자가 두 개 이상이면 인자들을 괄호로 묶어줘야 한다.
s indexOf ('o', 5)

/*
전위 연산자로는 +, -, !, ~ 만 가능하다.
 */
-2.0
// 전위 연산자 역시 unary_ 라는 특수한 prefix를 붙여 메서드로 표현가능하다.
(2.0).unary_-

/*
후위 연산자는 인자가 없는 메서드를 '.' 이나 괄호 없이 호출하는 경우다.
메서드 호출시 빈 괄호를 생략할 수 있다.
관례상 메서드에 부수효과가 있다면 괄호를 넣고, 아니라면 생략한다.
 */
"aBc".toLowerCase()
"aBc".toLowerCase
"aBc" toLowerCase

/*
스칼라의 == 은 equals 를 호출한다.
자바의 == 처럼 참조 동일성을 확인하려면 eq, ne 연산자를 사용한다.
하지만 eq, ne 는 자바 객체에 직접 매핑한 객체에만 사용할 수 있다.
 */
val str1 = "abc"
val str2 = "abc"
val str3 = new String("abc")
str1 == str2
str1 eq str2
str2 == str3
str2 eq str3 // 이것만 false