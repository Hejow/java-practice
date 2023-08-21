package `go-kotlin`

import java.lang.IllegalArgumentException

// 범위 표현 개사기네 진짜
fun validateScoreIsNotNegative2(score: Int) {
    if (score in 0..100) {
        throw IllegalArgumentException()
    }
}

// 자바의 조건문과 똑같다.
fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException()
    }
}

// expression은 하나의 값으로 도출되는 것.
// 삼항 연산자가 expression이면서 statement -> 코틀린에서는 없다.
fun getPassOrFail(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

// 위와 동일
fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else {
        "C"
    }
}

fun getGradeWithSwitch(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
//        score / 10 == 7 -> "C"
//        7 -> "C"
//        else -> "D"
        else -> "D"
    }
}

fun startsWith(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when (number) {
        1, 0, -1 -> println()
        else -> println()
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println()
        number % 2 == 0 -> println()
        else -> println()
    }
}
