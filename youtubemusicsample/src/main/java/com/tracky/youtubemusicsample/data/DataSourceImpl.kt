package com.tracky.youtubemusicsample.data

import com.tracky.youtubemusicsample.domain.model.YoutubeFeeds
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//class DataSourceImpl(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : DataSource {
//    override suspend fun initialFetch(): YoutubeFeeds =
//        withContext(dispatcher) {
//            YoutubeFeeds()
//        }
//}
