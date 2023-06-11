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
