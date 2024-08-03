package kang.min.todo

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kang.min.todo.ui.TodoCheckBox
import kang.min.ui.theme.TodoTheme

@Composable
fun TodoScreen() {
    TodoCheckBox()
}

@Preview(showBackground = true)
@Composable
internal fun TodoScreenPreview() {
    TodoTheme {
        TodoScreen()
    }
}