package menu.constants

object Day {
    private const val TITLE = "구분"
    private val DAY_STORE = listOf("월요일", "화요일", "수요일", "목요일", "금요일")

    fun getSize() = DAY_STORE.size

    override fun toString() =
        "[ $TITLE${StringConstants.SEPARATOR}${DAY_STORE.joinToString(StringConstants.SEPARATOR.toString())} ]"
}