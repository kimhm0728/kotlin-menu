package menu.io.input

import menu.io.util.convertStringWithComma

class InputView {

    private val validator = InputValidator()

    fun inputCoachNames(): List<String> {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        val input = readlnOrNull()
        println()

        validator.validateCoachNames(input)
        return input!!.convertStringWithComma()
    }

    fun inputCoachHateMenu(name: String): List<String> {
        println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        val input = readlnOrNull()
        println()

        validator.validateCoachHateMenu(input)
        return input!!.convertStringWithComma()
    }
}