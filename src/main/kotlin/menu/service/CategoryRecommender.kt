package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.constants.Menu
import menu.model.Category

object CategoryRecommender {

    fun recommend(recommendedCategory: Category): Menu {
        var menu: Menu

        while (true) {
            menu = CategoryClassifier.getMenuByCategory(Randoms.pickNumberInRange(1, 5))
            if (!recommendedCategory.possibleRecommend(menu.getTitles())) continue

            recommendedCategory.add(menu.getTitles())
            break
        }

        return menu
    }
}