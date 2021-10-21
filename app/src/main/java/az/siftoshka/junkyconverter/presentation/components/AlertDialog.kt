package az.siftoshka.junkyconverter.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import az.siftoshka.junkyconverter.presentation.utils.Padding

@ExperimentalMaterialApi
@Composable
fun JunkyDialog(
    @StringRes title: Int,
    @StringRes text: Int,
    @StringRes textButton: Int,
    state: MutableState<Boolean>,
    onPerformClick: () -> Unit
) {

    if (state.value) {
        AlertDialog(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.background(MaterialTheme.colors.surface, RoundedCornerShape(20.dp)),
            onDismissRequest = { state.value = false },
            text = {
                Text(
                    text = stringResource(id = text),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                )
            },
            title = {
                Text(
                    text = stringResource(id = title),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                )
            },
            buttons = {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = Padding.Default)
                ) {
                    Card(
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.padding(horizontal = Padding.Default),
                        backgroundColor = MaterialTheme.colors.surface,
                        elevation = 0.dp,
                        onClick = onPerformClick

                    ) {
                        Text(
                            text = stringResource(id = textButton),
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(Padding.Default)
                        )
                    }
                }
            }
        )
    }
}