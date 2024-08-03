package kang.min.gu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kang.min.navigation.Destination
import kang.min.todo.TodoScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: Destination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Destination.Todo> {
            TodoScreen()
        }
    }
}