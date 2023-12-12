package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Coach

object MenuRecommender {

    fun recommend(menus: List<String>, coach: Coach) {
        var menu: String

        while (true) {
            menu = Randoms.shuffle(menus)[0]
            if (!coach.possibleRecommendMenu(menu)) continue

            coach.addMenu(menu)
            return
        }
    }
}