package menu.io.input

import menu.util.convertStringWithComma
import menu.service.MenuClassifier

class InputValidator {

    fun validateCoachNames(input: String) = with(input.convertStringWithComma()) {
        validateDuplication()
        validateCoachSize()

        forEach { name ->
            name.validateNameLength()
            name.validateKoreanName()
        }
    }

    fun validateNoHateMenu(input: String) = input == ""

    fun validateCoachHateMenu(input: String) = with(input.convertStringWithComma()) {
        validateDuplication()
        validateHateMenuSize()

        forEach { menu ->
            menu.validateMenu()
        }
    }

    private fun String.validateNameLength() =
        require(this.length in NAME_MIN_LENGTH..NAME_MAX_LENGTH) {
            "$NAME_MIN_LENGTH~${NAME_MAX_LENGTH}글자 내의 이름을 입력해 주세요. "
        }

    private fun List<String>.validateDuplication() =
        require(this.size == this.distinct().size) { "중복되지 않는 이름/메뉴를 입력해 주세요." }

    private fun String.validateKoreanName() =
        require("^[가-힣]*$".toRegex().matches(this)) { "한글로 된 이름을 입력해 주세요." }

    private fun List<String>.validateCoachSize() =
        require(size in NAME_MIN_SIZE..NAME_MAX_SIZE) {
            "$NAME_MIN_SIZE~${NAME_MAX_SIZE}개의 이름을 입력해 주세요."
        }

    private fun List<String>.validateHateMenuSize() =
        require(size in MENU_MIN_SIZE..MENU_MAX_SIZE) {
            "$MENU_MIN_SIZE~${MENU_MAX_SIZE}개의 메뉴를 입력해 주세요."
        }

    private fun String.validateMenu() =
        require(MenuClassifier.containsMenu(this)) { "존재하는 메뉴를 입력해 주세요." }

    companion object {
        private const val NAME_MIN_LENGTH = 2
        private const val NAME_MAX_LENGTH = 5
        private const val NAME_MIN_SIZE = 2
        private const val NAME_MAX_SIZE = 5
        private const val MENU_MIN_SIZE = 0
        private const val MENU_MAX_SIZE = 2
    }
}