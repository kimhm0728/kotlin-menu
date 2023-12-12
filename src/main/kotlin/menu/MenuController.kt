package menu

import menu.io.input.InputView
import menu.model.Coach
import menu.io.output.OutputView
import menu.service.Recommender
import menu.util.retryWhileNoException

class MenuController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private val coachNames: List<String>
    private val coachs: List<Coach>

    init {
        outputView.printStartMessage()

        coachNames = inputCoachNames()
        coachs = composeCoachsValue()
    }

    private fun inputCoachNames(): List<String> =
        retryWhileNoException { inputView.inputCoachNames() }

    private fun inputCoachHateMenus(name: String): List<String> =
        retryWhileNoException { inputView.inputCoachHateMenus(name) }

    private fun composeCoachsValue() =
        mutableListOf<Coach>().apply {
            coachNames.forEach { name ->
                add(Coach(name, inputCoachHateMenus(name)))
            }
        }.toList()

    fun start() {
        val recommender = Recommender(coachs)
        val category = recommender.recommend()
    }
}