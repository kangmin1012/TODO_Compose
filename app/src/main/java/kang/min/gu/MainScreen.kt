package kang.min.gu

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kang.min.gu.navigation.MainNavHost
import kang.min.navigation.Todo

@Composable
internal fun MainScreen(
    navigator: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MainNavHost(
            navigator,
            Todo
        )
    }
}