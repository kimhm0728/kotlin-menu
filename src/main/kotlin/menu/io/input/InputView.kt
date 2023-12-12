package menu.io.input

import camp.nextstep.edu.missionutils.Console
import menu.util.convertStringWithComma

class InputView {

    private val validator = InputValidator()

    fun inputCoachNames(): List<String> {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        val input = Console.readLine()
        println()

        validator.validateCoachNames(input)
        return input.convertStringWithComma()
    }

    fun inputCoachHateMenus(name: String): List<String> {
        println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        val input = Console.readLine()
        println()

        if (validator.validateNoHateMenu(input)) return listOf()

        validator.validateCoachHateMenu(input)
        return input.convertStringWithComma()
    }
}