package az.siftoshka.junkyconverter.presentation.components

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import az.siftoshka.junkyconverter.presentation.utils.Padding

@ExperimentalMaterialApi
@Composable
fun FoldableText(
    @StringRes shortText: Int,
    @StringRes longText: Int
) {
    var short by remember { mutableStateOf(true) }

    Card(
        shape = MaterialTheme.shapes.large,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp,
        onClick = { short = !short },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Padding.Smallest)
            .animateContentSize(tween(400))
    ) {
        Text(
            text = stringResource(id = shortText),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(Padding.Default)
        )
        if (!short) {
            Text(
                text = "\n\n" + stringResource(id = longText),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondaryVariant,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(Padding.Default)
            )
        }
    }
}