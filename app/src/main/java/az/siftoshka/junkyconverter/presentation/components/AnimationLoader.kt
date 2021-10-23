package az.siftoshka.junkyconverter.presentation.components

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimationLoader(@RawRes value: Int, modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(value))
    LottieAnimation(modifier = modifier, composition = composition, contentScale = ContentScale.FillBounds)
}