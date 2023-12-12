package menu.constants

class ChineseMenu : Menu {

    override fun getTitles() = "중식"

    override fun getMenus() = listOf(
        "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
    )
}