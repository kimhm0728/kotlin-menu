package menu.service

import menu.constants.menu.*

object MenuClassifier {

    private val menuStore = mutableSetOf<String>().apply {
        addAll(AsianMenu().getMenus())
        addAll(ChineseMenu().getMenus())
        addAll(JapaneseMenu().getMenus())
        addAll(KoreanMenu().getMenus())
        addAll(WesternMenu().getMenus())
    }.toSet()

    fun containsMenu(menu: String) = menuStore.contains(menu)
}