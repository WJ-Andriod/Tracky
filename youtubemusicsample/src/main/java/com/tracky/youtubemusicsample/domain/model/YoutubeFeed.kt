package com.tracky.youtubemusicsample.domain.model

import com.google.gson.annotations.JsonAdapter

data class YoutubeFeeds(
    val youtubeFeeds: List<YoutubeFeed>
)

sealed class YoutubeFeed(
    open val id: String,
    open val title: String,
    open val description: String,
    open val imageUrl: String,
    open val contentType: String
) {
    @JsonAdapter(ReplayFeedDeserializer::class)
    data class ReplayFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val userName: String
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    @JsonAdapter(ChartTopperFeedDeserializer::class)
    data class ChartTopperFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val musics: List<Album.Music>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    @JsonAdapter(UpbeatPlayListFeedDeserializer::class)
    data class UpbeatPlayListFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val musics: List<Album.Music>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    @JsonAdapter(InterimFinancialReportMusicFeedDeserializer::class)
    data class InterimFinancialReportMusicFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val mainlyMusicList: List<MainlyMusicList>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    @JsonAdapter(ChartFeedDeserializer::class)
    data class ChartFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val top100Musics: List<Album.Music>,
        val top100Videos: List<Album.Video>,
        val popular20Videos: List<Album.Video>,
        val globalTop100Musics: List<Album.Music>,
        val globalTop100Videos: List<Album.Video>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    @JsonAdapter(MusicVideoFeedDeserializer::class)
    data class MusicVideoFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val mainlyVideoList: List<MainlyVideoList>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    @JsonAdapter(InterimFinancialReportVideoFeedDeserializer::class)
    data class InterimFinancialReportVideoFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val mainlyVideoList: List<MainlyVideoList>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    @JsonAdapter(RecommendFeedDeserializer::class)
    data class RecommendFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val totalMusicCount: String,
        val musics: List<Album.Music>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )
}

@JsonAdapter(MainlyMusicListDeserializer::class)
data class MainlyMusicList(
    val mainlyThumbnail: String,
    val mainlyTitle: String,
    val musics: List<Album.Music>
)

@JsonAdapter(MainlyVideoListDeserializer::class)
data class MainlyVideoList(
    val mainlyThumbnail: String,
    val mainlyTitle: String,
    val videos: List<Album.Video>
)

sealed class Album(
    open val title: String,
    open val description: String,
    open val year: String,
    open val thumbnail: String,
    open val artist: Artist,
    open val duration: String,
    open val views: String,
    open val nation: String
) {
    @JsonAdapter(MusicDeserializer::class)
    data class Music(
        override val title: String,
        override val description: String,
        override val year: String,
        override val thumbnail: String,
        override val artist: Artist,
        override val duration: String,
        override val views: String,
        override val nation: String
    ) : Album(
        title = title,
        description = description,
        year = year,
        thumbnail = thumbnail,
        artist = artist,
        duration = duration,
        views = views,
        nation = nation
    )

    @JsonAdapter(VideoDeserializer::class)
    data class Video(
        override val title: String,
        override val description: String,
        override val year: String,
        override val thumbnail: String,
        override val artist: Artist,
        override val duration: String,
        override val views: String,
        override val nation: String
    ) : Album(
        title = title,
        description = description,
        year = year,
        thumbnail = thumbnail,
        artist = artist,
        duration = duration,
        views = views,
        nation = nation
    )
}

@JsonAdapter(ArtistDeserializer::class)
data class Artist(
    val name: String,
    val imageUrl: String,
    val debutYear: String,
    val totalSubscriber: String
)
