package com.tracky.youtubemusicsample.data

import com.tracky.youtubemusicsample.domain.model.YoutubeFeeds
import javax.inject.Inject

class DataSourceImpl @Inject constructor() : DataSource {
    override suspend fun initialFetch(): YoutubeFeeds = getYoutubeFeeds()

    private fun getYoutubeFeeds() = YoutubeFeeds(
        tabs = tabs,
        youtubeFeeds = listOf(
            replayFeed,
            chartTopperFeeds.random(),
            upbeatPlayListFeeds.random(),
            interimFinancialReportMusicFeeds.random(),
            chartFeeds.random(),
            musicVideoFeeds.random(),
            interimFinancialReportVideoFeeds.random(),
            recommendFeeds.random()
        )
    )
}
