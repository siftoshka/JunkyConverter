package az.siftoshka.junkyconverter.domain.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.text.DecimalFormat

/**
 *  General extension file.
 */
fun String.moneyFormat(): String {
    if (this == "0") return this
    return if (contains(".")) DecimalFormat("##,###.00").format(toFloat())
    else DecimalFormat("##,###").format(toFloat())
}

fun Context.getGithubIntent() = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.DEV_GITHUB)))

fun Context.getTelegramIntent() = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.DEV_TELEGRAM)))

fun Context.getInstagramIntent() = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.DEV_INSTAGRAM)))