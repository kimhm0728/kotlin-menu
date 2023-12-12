package menu.service

import menu.constants.Day
import menu.model.Category
import menu.model.Coach

class Recommender(private val coachs: List<Coach>) {

    fun recommend(): Category {
        val daySize = Day.getSize()
        val category = Category()

        for (cnt in 1..daySize) {
            recommendByDay(category)
        }

        return category
    }

    private fun recommendByDay(category: Category) {
        val menus = CategoryRecommender.recommend(category)

        coachs.forEach { coach ->
            MenuRecommender.recommend(menus.getMenus(), coach)
        }
    }
}