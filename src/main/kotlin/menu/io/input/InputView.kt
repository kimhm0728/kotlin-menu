package menu.io.input

class InputView {
    private val validator = InputValidator()
    private val converter = InputConverter()

    fun inputCoachNames(): List<String> {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        val input = readlnOrNull()

        validator.validateCoachNames(input)
        return converter.convertCoachNames(input!!)
    }
}