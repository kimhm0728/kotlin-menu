package menu.io.output

import menu.constants.Day
import menu.model.Category
import menu.model.Coach

class OutputView {

    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.")
        lineBreak()
    }

    fun printRecommendResult(category: Category, coachs: List<Coach>) {
        println("메뉴 추천 결과입니다.")
        println(Day)
        println(category)

        coachs.forEach { coach -> println(coach) }
        lineBreak()
    }

    fun printEndMessage() = println("추천을 완료했습니다.")

    private fun lineBreak() = println()
}