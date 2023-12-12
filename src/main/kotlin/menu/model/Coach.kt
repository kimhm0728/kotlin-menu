package menu.model

class Coach(private val name: String, private val hateMenus: List<String>) {

    private val recommendedMenus = mutableListOf<String>()

    fun possibleRecommendMenu(menu: String) =
        !recommendedMenus.contains(menu)

    fun addMenu(menu: String) = recommendedMenus.add(menu)
}