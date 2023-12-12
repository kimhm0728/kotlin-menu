package menu.model

import menu.constants.StringConstants

class Category {
    private val title = "카테고리"
    private val categoryStore = mutableListOf<String>()

    fun isRecommendAlready(category: String) =
        categoryStore.contains(category)

    fun addCategory(category: String) =
        categoryStore.add(category)

    override fun toString() =
        "[ $title${StringConstants.SEPARATOR}${categoryStore.joinToString(StringConstants.SEPARATOR.toString())} ]"
}