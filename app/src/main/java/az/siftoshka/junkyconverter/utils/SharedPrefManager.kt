package az.siftoshka.junkyconverter.utils

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Singleton class to manage [SharedPreferences].
 */
@Singleton
class SharedPrefManager @Inject constructor(private val preferences: SharedPreferences) {

    companion object {

        private const val KEY_SHOWN_INTRO = "key_shown_intro"
    }

    fun isIntroShown() = preferences.getBoolean(KEY_SHOWN_INTRO, false)

    fun setIntroShown(value: Boolean) {
        preferences.edit(commit = true) {
            putBoolean(KEY_SHOWN_INTRO, value)
        }
    }
}