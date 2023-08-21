package `go-kotlin`

fun main() {
    var number1: Long = 10L // 수정 가능
    val number2 = 10L // 수정 불가

    // 꼭 필요할 때만 var로 선언한다. 이 외에는 val
    // 코틀린은 알아서 wrapper 타입과 기본 타입에 대해서 알아서 변환해준다.

    // null이 들어갈 수 있음은 타입 뒤에 ?로 표현한다. 아예 다르게 취급한다.
    var number3: Long? = 1_000L
    number3 = null

    // 코틀린은 인스턴스화할 때 new를 쓰지 않는다....

    // safe call : null이 아니면 실행하고 null이면 실행하지 않는다.. 이게 말이 되냐..
    val str: String? = "ABC"
    println(str?.length)

    // elvis 연산자 : null이면 실행하는 값
    println(str?.length ?: 0)

    // 자바 코드를 사용할 때는 플랫폼 타입 사용에 유의해야 한다.
}

// null이 들어갈 수 있는 타입을 완전 다르게 취급한다..
fun startsWithA1(str: String?): Boolean {
//    if (str == null) {
//        throw IllegalArgumentException("null inserted")
//    }
//    return str.startsWith("A")
    return str?.startsWith("A") ?: throw IllegalArgumentException("null inserted")
}

fun startsWithA2(str: String?): Boolean? {
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")
    return str?.startsWith("A") ?: false
}

fun startsWith(str: String?): Boolean {
    // 절대 null이 아님을 표현! null이면 NPE가 뜰 수도 있다.
    return str!!.startsWith("A")
}
