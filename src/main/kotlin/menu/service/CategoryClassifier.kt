package menu.service

import menu.constants.menu.*

object CategoryClassifier {

    private val categoryStore = mapOf(
        1 to JapaneseMenu(),
        2 to KoreanMenu(),
        3 to ChineseMenu(),
        4 to AsianMenu(),
        5 to WesternMenu()
    )

    fun getMenuByCategory(category: Int) = categoryStore[category]!!
}