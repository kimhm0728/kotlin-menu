package menu.io.input

import menu.util.convertStringWithComma
import menu.service.MenuClassifier

class InputValidator {

    fun validateCoachNames(input: String) {
        with(input.convertStringWithComma()) {
            validateDuplication()
            validateCoachSize()

            forEach { name ->
                name.validateNameLength()
                name.validateKoreanName()
            }
        }
    }

    fun validateCoachHateMenu(input: String) {
        with(input.convertStringWithComma()) {
            validateDuplication()
            validateHateMenuSize()

            forEach { menu ->
                menu.validateMenu()
            }
        }
    }

    private fun String.validateNameLength() {
        require(this.length in 2..5) { "2~5글자 내의 이름을 입력해 주세요. "}
    }

    private fun List<String>.validateDuplication() {
        require(this.size == this.distinct().size) { "중복되지 않는 이름/메뉴를 입력해 주세요." }
    }

    private fun String.validateKoreanName() {
        require("^[가-힣]*$".toRegex().matches(this)) { "한글로 된 이름을 입력해 주세요." }
    }

    private fun List<String>.validateCoachSize() {
        require(size in 2..5) { "2~5개의 이름을 입력해 주세요." }
    }

    private fun List<String>.validateHateMenuSize() {
        require(size < 3) { "0~2개의 메뉴를 입력해 주세요." }
    }

    private fun String.validateMenu() {
        require(MenuClassifier.containsMenu(this)) { "존재하는 메뉴를 입력해 주세요." }
    }
}