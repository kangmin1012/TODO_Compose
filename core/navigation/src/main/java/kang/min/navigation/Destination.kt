package kang.min.navigation

interface Destination {
    val route: String
}

object Todo : Destination {
    override val route: String
        get() = "Todo"
}