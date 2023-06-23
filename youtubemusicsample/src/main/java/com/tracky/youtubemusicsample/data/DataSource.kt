package com.tracky.youtubemusicsample.data

import com.tracky.youtubemusicsample.domain.model.YoutubeFeeds

interface DataSource {
    suspend fun initialFetch(): YoutubeFeeds
}
