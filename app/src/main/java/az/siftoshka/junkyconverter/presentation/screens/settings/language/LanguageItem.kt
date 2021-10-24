package az.siftoshka.junkyconverter.presentation.screens.settings.language

import androidx.annotation.StringRes
import az.siftoshka.junkyconverter.R
import az.siftoshka.junkyconverter.domain.utils.Language

/**
 * Item for language.
 */
class LanguageItem(
    val category: LanguageCategory,
    @StringRes var text: Int,
    var code: String? = null,
    )

enum class LanguageCategory {
    AUTO,
    ENGLISH,
    AZERBAIJANI,
    SPANISH,
    FRENCH,
    RUSSIAN
}

val languages = mutableListOf(
    LanguageItem(
        LanguageCategory.AUTO,
        R.string.text_lang_automatic
    ),
    LanguageItem(
        LanguageCategory.ENGLISH,
        R.string.text_lang_english,
        Language.ENGLISH.language
    ),
    LanguageItem(
        LanguageCategory.AZERBAIJANI,
        R.string.text_lang_azerbaijani,
        Language.AZERBAIJANI.language
    ),
    LanguageItem(
        LanguageCategory.SPANISH,
        R.string.text_lang_spanish,
        Language.SPANISH.language
    ),
    LanguageItem(
        LanguageCategory.FRENCH,
        R.string.text_lang_french,
        Language.FRENCH.language
    ),
    LanguageItem(
        LanguageCategory.RUSSIAN,
        R.string.text_lang_russian,
        Language.RUSSIAN.language
    )
).sortedBy { it.code }