package menu.io.input

class InputValidator {
    fun validateCoachNames(input: String?) {
        input.validateNull()

        with(input!!.convertStringList()) {
            validateDuplication()
            validateCoachSize()

            this.forEach { name ->
                name.validateNameLength()
                name.validateKoreanName()
            }
        }
    }

    private fun String?.validateNull() {
        require(this != null) { "유효한 값을 입력해 주세요." }
    }

    private fun String.validateNameLength() {
        require(this.length in 2..5) { "2~5글자 내의 이름을 입력해 주세요. "}
    }

    private fun List<String>.validateDuplication() {
        require(this.size == this.distinct().size) { "중복되지 않는 이름을 입력해 주세요." }
    }

    private fun String.validateKoreanName() {
        require("가-힣".toRegex().matches(this)) { "한글로 된 이름을 입력해 주세요." }
    }

    private fun List<String>.validateCoachSize() {
        require(size in 2..5) { "2~5개의 이름을 입력해 주세요." }
    }

    private fun String.convertStringList() = this.split(",")
}