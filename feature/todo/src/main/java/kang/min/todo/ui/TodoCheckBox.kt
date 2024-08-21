package kang.min.todo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kang.min.ui.theme.TodoTheme

@Composable
internal fun TodoCheckBox() {

    val (checked, setChecked) = remember{ mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                setChecked(!checked)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = Modifier,
            checked = checked,
            onCheckedChange = { setChecked(it) }
        )
        Text(
            text = "card"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoCheckBoxPreview() {
    TodoTheme {
        TodoCheckBox()
    }
}