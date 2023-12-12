package menu.model

import menu.constants.StringConstants

class Coach(private val name: String, private val hateMenus: List<String>) {

    private val recommendedMenus = mutableListOf<String>()

    fun possibleRecommendMenu(menu: String) =
        !recommendedMenus.contains(menu)

    fun addMenu(menu: String) = recommendedMenus.add(menu)

    override fun toString() =
        "[ $name${StringConstants.SEPARATOR}${recommendedMenus.joinToString(StringConstants.SEPARATOR.toString())} ]"
}