package com.tracky.youtubemusicsample.domain.model

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
    // 다시 듣기
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

    // 인기 급상승곡
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

    // 빠른 선곡
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

    // 중간 음악 결산
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

    // 차트
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

    // 뮤직비디오
    data class MusicVideoFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val videos: List<Album.Video>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    // 중간 비디오
    data class InterimFinancialReportVideoFeed(
        override val id: String,
        override val title: String,
        override val description: String,
        override val imageUrl: String,
        override val contentType: String,
        val mainlyVideoList: List<Album.Video>
    ) : YoutubeFeed(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentType = contentType
    )

    // 추천
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

data class MainlyMusicList(
    val mainlyThumbnail: String,
    val mainlyTitle: String,
    val musics: List<Album.Music>
)

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

data class Artist(
    val name: String,
    val imageUrl: String,
    val debutYear: String,
    val totalSubscriber: String
)
