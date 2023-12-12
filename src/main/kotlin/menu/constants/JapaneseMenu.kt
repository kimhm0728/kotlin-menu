package menu.constants

class JapaneseMenu : Menu {

    override fun getTitles() = "일식"

    override fun getMenus() = listOf(
        "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"
    )
}