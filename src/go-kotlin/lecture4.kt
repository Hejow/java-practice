package `go-kotlin`

fun main() {
    // 일반적인 산술연산자 쪽은 동일
    // 비교 연산자도 동일하다. 객체에 대해서 자동으로 compareTo를 호출해준다.
    // 동일성 비교는 ===, 동등성 비교는 == (자동으로 equals 호출)

    val i = 10
    val i1 = 10
    println(i === i1)
    println(i == i1)

    // 논리 연산자도 동일하다. Lazy 연산을 수행한다.
    // in / !in : 포함된다, 안된다.
    // 코틀린에서는 연산자를 직접 오버로딩할 수 있다.
}
