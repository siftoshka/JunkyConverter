package az.siftoshka.junkyconverter.domain.utils

/**
 * Enum class for language selector.
 */
enum class Language(val id: Int, val language: String, val country: String) {
    ENGLISH(1, "en", "GB"),
    AZERBAIJANI(2, "az", "AZ"),
    SPANISH(3, "es", "BR"),
    ITALIANO(4, "it", "IT"),
    RUSSIAN(5, "ru", "RU");

    companion object {

        fun isLanguageSupported(language: String) : Boolean {
            for (element in values()) {
                if (element.language.contentEquals(language)) {
                    return true
                }
            }
            return false
        }
    }
}