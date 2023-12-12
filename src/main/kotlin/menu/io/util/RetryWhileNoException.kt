package menu.io.util

inline fun <T> retryWhileNoException(action: () -> T): T {
    while (true) {
        try {
            return action()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] $e")
        }
    }
}