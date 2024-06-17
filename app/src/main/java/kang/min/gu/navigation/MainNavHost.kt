package kang.min.gu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kang.min.todo.TodoScreen

@Composable
fun MainNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "Todo"
    ) {
        composable("Todo") {
            TodoScreen()
        }
    }
}