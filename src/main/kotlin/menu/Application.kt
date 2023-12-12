package menu

import menu.io.MenuController
import menu.io.input.InputView
import menu.io.output.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val menuController = MenuController(inputView, outputView)

    menuController.start()
}
