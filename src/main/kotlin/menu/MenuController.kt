package menu

import menu.io.input.InputView
import menu.model.Coach
import menu.io.output.OutputView
import menu.model.Category
import menu.service.Recommender
import menu.util.retryWhileNoException

class MenuController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private val coachs: List<Coach>

    init {
        outputView.printStartMessage()

        val coachNames = inputCoachNames()
        coachs = setUpCoachs(coachNames)
    }

    private fun inputCoachNames(): List<String> =
        retryWhileNoException { inputView.inputCoachNames() }

    private fun inputCoachHateMenus(name: String): List<String> =
        retryWhileNoException { inputView.inputCoachHateMenus(name) }

    private fun setUpCoachs(coachNames: List<String>): List<Coach> {
        val _coachs = mutableListOf<Coach>()
        coachNames.forEach { name ->
            _coachs.add(Coach(name, inputCoachHateMenus(name)))
        }

        return _coachs.toList()
    }

    fun start() {
        val category = Category()
        val recommender = Recommender(coachs)
        recommender.recommendByWeek(category)

        outputView.printRecommendResult(category, coachs)
        outputView.printEndMessage()
    }
}