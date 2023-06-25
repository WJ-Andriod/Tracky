package com.tracky.youtubemusicsample

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

object YoutubeScreen {
    @Composable
    fun Screen(viewModel: YoutubeMusicViewModel = hiltViewModel()) {
        val context = LocalContext.current
        val state = viewModel.feedState.collectAsState().value

        if (state.tabs.isNotEmpty()) {
            Toast.makeText(context, "tab: ${state.tabs}", Toast.LENGTH_SHORT).show()
        }
    }
}
