package com.tracky.youtubemusicsample.domain.model

import android.provider.MediaStore.MediaColumns.ALBUM_ARTIST
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.tracky.youtubemusicsample.EMPTY
import java.lang.reflect.Type

private const val GLOBAL_TOP_100_VIDEOS = "globalTop100VideoList"
private const val GLOBAL_TOP_100_MUSICS = "globalTop100MusicList"
private const val POPULAR_20_VIDEOS = "popular20VideoList"
private const val TOP_100_VIDEOS = "top100VideoList"
private const val TOP_100_MUSICS = "top100MusicList"
private const val MAINLY_VIDEO_LIST = "mainlyVideoList"
private const val MAINLY_MUSIC_LIST = "mainlyMusicList"
private const val ID = "id"
private const val CONTENT_TYPE = "contentType"
private const val TOTAL_MUSIC_COUNT = "totalMusicCount"
private const val MUSICS = "musics"
private const val VIDEOS = "videos"
private const val TITLE = "title"
private const val DESCRIPTION = "description"
private const val YEAR = "year"
private const val THUMBNAIL = "thumbnail"
private const val ARTIST = "artist"
private const val DURATION = "duration"
private const val VIEWS = "views"
private const val NATION = "nation"
private const val NAME = "name"
private const val IMAGE_URL = "imageUrl"
private const val DEBUT_YEAR = "debutYear"
private const val TOTAL_SUBSCRIBER = "totalSubscriber"

class ReplayFeedDeserializer : JsonDeserializer<YoutubeFeed.ReplayFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.ReplayFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.ReplayFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            userName = obj?.get(NAME)?.asString ?: EMPTY
        )
    }
}

class ChartTopperFeedDeserializer : JsonDeserializer<YoutubeFeed.ChartTopperFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.ChartTopperFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.ChartTopperFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            musics = obj?.get(MUSICS)?.toString().parseJson<List<Album.Music>>().orEmpty()
        )
    }
}

class UpbeatPlayListFeedDeserializer : JsonDeserializer<YoutubeFeed.UpbeatPlayListFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.UpbeatPlayListFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.UpbeatPlayListFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            musics = obj?.get(MUSICS)?.toString().parseJson<List<Album.Music>>().orEmpty()
        )
    }
}

class InterimFinancialReportMusicFeedDeserializer : JsonDeserializer<YoutubeFeed.InterimFinancialReportMusicFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.InterimFinancialReportMusicFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.InterimFinancialReportMusicFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            mainlyMusicList = obj?.get(MAINLY_MUSIC_LIST).toString().parseJson<List<MainlyMusicList>>().orEmpty()
        )
    }
}

class ChartFeedDeserializer : JsonDeserializer<YoutubeFeed.ChartFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.ChartFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.ChartFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            top100Musics = obj?.get(TOP_100_MUSICS)?.toString().parseJson<List<Album.Music>>().orEmpty(),
            top100Videos = obj?.get(TOP_100_VIDEOS)?.toString().parseJson<List<Album.Video>>().orEmpty(),
            popular20Videos = obj?.get(POPULAR_20_VIDEOS)?.toString().parseJson<List<Album.Video>>().orEmpty(),
            globalTop100Musics = obj?.get(GLOBAL_TOP_100_MUSICS)?.toString().parseJson<List<Album.Music>>().orEmpty(),
            globalTop100Videos = obj?.get(GLOBAL_TOP_100_VIDEOS)?.toString().parseJson<List<Album.Video>>().orEmpty()
        )
    }
}

class MusicVideoFeedDeserializer : JsonDeserializer<YoutubeFeed.MusicVideoFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.MusicVideoFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.MusicVideoFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            mainlyVideoList = obj?.get(MAINLY_VIDEO_LIST).toString().parseJson<List<MainlyVideoList>>().orEmpty()
        )
    }
}

class InterimFinancialReportVideoFeedDeserializer : JsonDeserializer<YoutubeFeed.InterimFinancialReportVideoFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.InterimFinancialReportVideoFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.InterimFinancialReportVideoFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            mainlyVideoList = obj?.get(MAINLY_VIDEO_LIST).toString().parseJson<List<MainlyVideoList>>().orEmpty()
        )
    }
}

class RecommendFeedDeserializer : JsonDeserializer<YoutubeFeed.RecommendFeed> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): YoutubeFeed.RecommendFeed = json?.asJsonObject.let { obj ->
        YoutubeFeed.RecommendFeed(
            id = obj?.get(ID)?.asString ?: EMPTY,
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            contentType = obj?.get(CONTENT_TYPE)?.asString ?: EMPTY,
            totalMusicCount = obj?.get(TOTAL_MUSIC_COUNT)?.asString ?: EMPTY,
            musics = obj?.get(MUSICS)?.toString()?.parseJson<List<Album.Music>>().orEmpty()
        )
    }
}

class MainlyVideoListDeserializer : JsonDeserializer<MainlyVideoList> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): MainlyVideoList = json?.asJsonObject.let { obj ->
        MainlyVideoList(
            mainlyThumbnail = obj?.get(THUMBNAIL)?.asString ?: EMPTY,
            mainlyTitle = obj?.get(TITLE)?.asString ?: EMPTY,
            videos = obj?.get(VIDEOS)?.toString()?.parseJson<List<Album.Video>>().orEmpty()
        )
    }
}

class MainlyMusicListDeserializer : JsonDeserializer<MainlyMusicList> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): MainlyMusicList = json?.asJsonObject.let { obj ->
        MainlyMusicList(
            mainlyThumbnail = obj?.get(THUMBNAIL)?.asString ?: EMPTY,
            mainlyTitle = obj?.get(TITLE)?.asString ?: EMPTY,
            musics = obj?.get(MUSICS)?.toString()?.parseJson<List<Album.Music>>().orEmpty()
        )
    }
}

class VideoDeserializer : JsonDeserializer<Album.Video> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Album.Video = json?.asJsonObject.let { obj ->
        Album.Video(
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            year = obj?.get(YEAR)?.asString ?: EMPTY,
            thumbnail = obj?.get(THUMBNAIL)?.asString ?: EMPTY,
            artist = obj?.get(ARTIST)?.asJsonObject.convertArtist(),
            duration = obj?.get(DURATION)?.asString ?: EMPTY,
            views = obj?.get(VIEWS)?.asString ?: EMPTY,
            nation = obj?.get(NATION)?.asString ?: EMPTY
        )
    }
}

class MusicDeserializer : JsonDeserializer<Album.Music> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Album.Music = json?.asJsonObject.let { obj ->
        Album.Music(
            title = obj?.get(TITLE)?.asString ?: EMPTY,
            description = obj?.get(DESCRIPTION)?.asString ?: EMPTY,
            year = obj?.get(YEAR)?.asString ?: EMPTY,
            thumbnail = obj?.get(THUMBNAIL)?.asString ?: EMPTY,
            artist = obj?.get(ARTIST)?.asJsonObject.convertArtist(),
            duration = obj?.get(DURATION)?.asString ?: EMPTY,
            views = obj?.get(VIEWS)?.asString ?: EMPTY,
            nation = obj?.get(NATION)?.asString ?: EMPTY
        )
    }
}

class ArtistDeserializer : JsonDeserializer<Artist> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Artist = json?.asJsonObject.let { obj ->
        Artist(
            name = obj?.get(NAME)?.asString ?: EMPTY,
            imageUrl = obj?.get(IMAGE_URL)?.asString ?: EMPTY,
            debutYear = obj?.get(DEBUT_YEAR)?.asString ?: EMPTY,
            totalSubscriber = obj?.get(TOTAL_SUBSCRIBER)?.asString ?: EMPTY
        )
    }
}

fun JsonObject?.convertArtist(): Artist {
    return this?.get(ALBUM_ARTIST)?.toString().parseJson<Artist>() ?: Artist(
        name = EMPTY,
        imageUrl = EMPTY,
        debutYear = EMPTY,
        totalSubscriber = EMPTY
    )
}

inline fun <reified T> type(): Type = object : TypeToken<T>() {}.type

inline fun <reified T> String?.parseJson(): T? = try {
    Gson().fromJson<T>(
        this,
        type<T>()
    )
} catch (_: Exception) {
    null
}
