package az.siftoshka.junkyconverter.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.siftoshka.junkyconverter.data.JunkRepository
import az.siftoshka.junkyconverter.data.model.Junk
import az.siftoshka.junkyconverter.utils.Resource
import az.siftoshka.junkyconverter.utils.SharedPrefManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * The [ViewModel] of the [MainScreen].
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getJunkUseCase: GetJunkUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MainScreenState())
    val state: State<MainScreenState> = _state

    init {
        getSelectedJunk()
    }

    private fun getSelectedJunk() {
        getJunkUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MainScreenState(junk = result.data)
                }
                is Resource.Error -> {
                    _state.value = MainScreenState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MainScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class MainScreenState(
    val isLoading: Boolean = false,
    val junk: Junk? = null,
    val error: String = ""
)

class GetJunkUseCase @Inject constructor(
    private val prefs: SharedPrefManager,
    private val repository: JunkRepository
) {

    operator fun invoke(): Flow<Resource<Junk>> = flow {
        try {
            emit(Resource.Loading())
            val junk = repository.getSelectedJunk(prefs.getSelectedJunk())
            emit(Resource.Success(junk))
        } catch (e: Exception) {
            emit(Resource.Error<Junk>(""))
        }
    }
}