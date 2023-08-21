package `go-kotlin`

fun main() {
    // 코틀린에서 타입 변환은 명시적으로 이루어져야 한다.
    // to타입 을 써야한다.
    val number1 = 3
    val number2 = number1.toLong()
    val number3 = 5
    val number4 = number1 / number3.toDouble() // 소수점 표현

    val number5: Int? = 3
    val number6: Long = number5?.toLong() ?: 0L // number5가 null일 수 있으니까 safe call을 해주고 elvis로 값을 정해준다.

    // Any는 자바의 Object
    // Unit은 자바의 void와 동일.
    // Unit 자체로 타입 인자로 사용가능하다.
    // 함수형 프로그래밍에서 unit은 단 하나의 인스턴스만 가짐을 의미 (싱글톤?). 즉, 코틀린의 유닛은 실제 존재하는 타입을 의미
    // Nothing은 함수가 정상적으로 끝나지 않았다는 사실을 표현 -> 무한 루프나 무조건 예외를 던질 때 사용

//    println("나이 : $number1")
//    val str = """
//        hello
//    """.trimIndent()

    // 코틀린에서 문자열에서 특정 문자 가져올 때 파이썬이랑 똑같다.
}

fun printAgeIfPerson(obj: Any?) {
//    if (obj is Person) {
//        val person = obj as Person
//        println(person)
//        println(obj)
//    }
//    if (obj !is Person) {
//        println(obj)
//    }

    val person = obj as? Person // obj가 null이 아니면 null, 해당 타입이 아니여도 null 리턴
    println(person?.toString())
}
