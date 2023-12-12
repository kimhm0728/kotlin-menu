package menu.constants.menu

class KoreanMenu : Menu {

    override fun getTitles() = "한식"

    override fun getMenus() = listOf(
        "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
    )
}