package menu.io.output

class OutputView {

    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.")
        lineBreak()
    }

    private fun lineBreak() = println()
}