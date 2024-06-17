package kang.min.todo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kang.min.ui.theme.TodoTheme

@Composable
fun TodoScreen() {
    Text(text = "hello")
}

@Preview(showBackground = true)
@Composable
internal fun TodoScreenPreview() {
    TodoTheme {
        TodoScreen()
    }
}