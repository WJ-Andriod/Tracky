package com.tracky.youtubemusicsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tracky.youtubemusicsample.data.DataSource
import com.tracky.youtubemusicsample.domain.model.YoutubeFeeds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YoutubeMusicViewModel @Inject constructor(
    private val dataSource: DataSource
) : ViewModel() {
    private val _feedsState = MutableStateFlow(YoutubeFeeds())
    val feedState: StateFlow<YoutubeFeeds>
        get() = _feedsState

    init {
        viewModelScope.launch {
            runCatching {
                dataSource.initialFetch()
            }.onSuccess {
                _feedsState.emit(it)
            }.onFailure {
                // NOTE: Something
            }
        }
    }
}
