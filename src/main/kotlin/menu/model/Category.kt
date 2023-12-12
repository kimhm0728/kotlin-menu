package menu.model

import menu.constants.StringConstants

class Category {

    private val title = "카테고리"
    private val categoryStore = mutableListOf<String>()
    private val categoryCount = mutableMapOf<String, Int>()

    fun possibleRecommend(category: String) =
        categoryCount.getOrDefault(category, 0) < CATEGORY_MAX

    fun add(category: String) {
        categoryStore.add(category)
        categoryCount[category] = categoryCount.getOrDefault(category, 0) + 1
    }

    override fun toString() =
        "[ $title${StringConstants.SEPARATOR}${categoryStore.joinToString(StringConstants.SEPARATOR.toString())} ]"

    companion object {
        private const val CATEGORY_MAX = 2
    }
}