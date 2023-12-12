package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.constants.Constants.CATEGORY_START_IDX
import menu.constants.Constants.CATEGORY_END_IDX
import menu.constants.menu.Menu
import menu.model.Category

object CategoryRecommender {

    fun recommend(recommendedCategory: Category): Menu {
        var menu: Menu

        while (true) {
            menu = CategoryClassifier.getMenuByCategory(
                Randoms.pickNumberInRange(CATEGORY_START_IDX.value, CATEGORY_END_IDX.value)
            )
            if (!recommendedCategory.possibleRecommend(menu.getTitles())) continue

            recommendedCategory.add(menu.getTitles())
            break
        }

        return menu
    }
}