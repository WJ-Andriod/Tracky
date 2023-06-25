package com.tracky.youtubemusicsample.data

import com.tracky.youtubemusicsample.R
import com.tracky.youtubemusicsample.domain.model.Album
import com.tracky.youtubemusicsample.domain.model.Artist
import com.tracky.youtubemusicsample.domain.model.MainlyMusicList
import com.tracky.youtubemusicsample.domain.model.MainlyVideoList
import com.tracky.youtubemusicsample.domain.model.Tab
import com.tracky.youtubemusicsample.domain.model.YoutubeFeed
import com.tracky.youtubemusicsample.domain.model.YoutubeFeeds

val tabs: List<Tab> = listOf(
    Tab(
        title = "휴식",
        isSelected = false
    ),
    Tab(
        title = "운동",
        isSelected = false
    ),
    Tab(
        title = "에너지 충전",
        isSelected = false
    ),
    Tab(
        title = "출퇴근",
        isSelected = false
    ),
    Tab(
        title = "집중",
        isSelected = false
    ),
    Tab(
        title = "힐링",
        isSelected = false
    ),
    Tab(
        title = "수면",
        isSelected = false
    ),
    Tab(
        title = "감성",
        isSelected = false
    ),
    Tab(
        title = "힙합",
        isSelected = false
    )
)

val artistNames: List<String> = listOf(
    "카리나",
    "윈터",
    "장원영",
    "수지",
    "현아",
    "해린",
    "뉴진스",
    "하니",
    "민지",
    "다니엘",
    "제니",
    "지수"
)

val durationList: List<String> = listOf(
    "2분 21초",
    "2분 28초",
    "2분 59초",
    "3분 01초",
    "3분 11초",
    "3분 22초",
    "3분 31초",
    "3분 41초",
    "3분 55초",
    "4분 09초"
)

val nationList: List<String> = listOf(
    "한국",
    "미국",
    "북한",
    "일본",
    "캐나다",
    "인도",
    "스위스",
    "영국",
    "프랑스",
    "스페인"
)

val musicNameList: List<String> = listOf(
    "지금은...",
    "더워? 나도 더워",
    "아이리스",
    "태양의 후예",
    "OMG",
    "Ditto",
    "Attention",
    "Cookie",
    "Tell Me",
    "Hurt",
    "Hype boy"
)

val videoNameList: List<String> = listOf(
    "[레전드] 지금 들어도 소름 듣는...",
    "더위가 날라가는 노래 리스트 100",
    "지금 떠나요...바다로!",
    "들으면 우주로 떠나는 여행",
    "바로 잠오는 음악"
)


val images: List<Int> = listOf(
    R.drawable.image_1,
    R.drawable.image_2,
    R.drawable.image_3,
    R.drawable.image_4,
    R.drawable.image_5,
    R.drawable.image_6,
    R.drawable.image_7,
    R.drawable.image_8,
    R.drawable.image_9,
    R.drawable.image_10
)

val replayFeed: YoutubeFeed.ReplayFeed =
    YoutubeFeed.ReplayFeed(
        id = "0",
        title = "다시 듣기",
        description = "replay description",
        imageUrl = getRandomImage(),
        contentType = "다시 듣기",
        userName = "user name: test_tm"
    )

val chartTopperFeeds = mutableListOf<YoutubeFeed.ChartTopperFeed>().apply {
    repeat(10) {
        add(
            YoutubeFeed.ChartTopperFeed(
                id = "id: $it",
                title = "TOP 100",
                description = "chart topper description: $it",
                imageUrl = getRandomImage(),
                contentType = "TOP 100",
                musics = getMusics()
            )
        )
    }
}

val upbeatPlayListFeeds = mutableListOf<YoutubeFeed.UpbeatPlayListFeed>().apply {
    repeat(10) {
        add(
            YoutubeFeed.UpbeatPlayListFeed(
                id = "id: $it",
                title = "지금 뜨는 인기곡",
                description = "upbeat play description: $it",
                imageUrl = getRandomImage(),
                contentType = "지금 뜨는 인기곡",
                musics = getMusics()
            )
        )
    }
}

val interimFinancialReportMusicFeeds = mutableListOf<YoutubeFeed.InterimFinancialReportMusicFeed>().apply {
    repeat(10) {
        add(
            YoutubeFeed.InterimFinancialReportMusicFeed(
                id = "id: $it",
                title = " 상반기 결산 곡",
                description = "upbeat play description: $it",
                imageUrl = getRandomImage(),
                contentType = "상반기 결산 곡",
                mainlyMusicList = listOf(getMainlyMusicList())
            )
        )
    }
}

val chartFeeds = mutableListOf<YoutubeFeed.ChartFeed>().apply {
    repeat(10) {
        add(
            YoutubeFeed.ChartFeed(
                id = "id: $it",
                title = "지금 듣기 좋은 음악 순위",
                description = "chart description: $it",
                imageUrl = getRandomImage(),
                contentType = "순위",
                top100Musics = getMusics(),
                top100Videos = getVideos(),
                popular20Videos = getVideos(),
                globalTop100Videos = getVideos(),
                globalTop100Musics = getMusics()
            )
        )
    }
}

val musicVideoFeeds = mutableListOf<YoutubeFeed.MusicVideoFeed>().apply {
    repeat(10) {
        add(
            YoutubeFeed.MusicVideoFeed(
                id = "id: $it",
                title = "뮤직 비디오 순위",
                description = "chart description: $it",
                imageUrl = getRandomImage(),
                contentType = "순위",
                mainlyVideoList = listOf(getMainlyVideoList())
            )
        )
    }
}

val interimFinancialReportVideoFeeds = mutableListOf<YoutubeFeed.InterimFinancialReportVideoFeed>().apply {
    repeat(10) {
        add(
            YoutubeFeed.InterimFinancialReportVideoFeed(
                id = "id: $it",
                title = " 상반기 뮤직 비디오 결산 곡",
                description = "upbeat play description: $it",
                imageUrl = getRandomImage(),
                contentType = "상반기 결산 곡",
                mainlyVideoList = listOf(getMainlyVideoList())
            )
        )
    }
}

val recommendFeeds = mutableListOf<YoutubeFeed.RecommendFeed>().apply {
    repeat(10) {
        add(
            YoutubeFeed.RecommendFeed(
                id = "id: $it",
                title = " 추천곡 리스트",
                description = "추천곡 리스트 description: $it",
                imageUrl = getRandomImage(),
                contentType = "추천곡",
                totalMusicCount = getViews(),
                musics = getMusics()
            )
        )
    }
}

fun getMusics(): List<Album.Music> {
    val musicList = mutableListOf<Album.Music>()
    repeat(10) {
        musicList.add(
            Album.Music(
                title = getMusicName(),
                description = "description: $it",
                year = (1991..2023).random().toString(),
                thumbnail = getRandomImage(),
                artist = getArtist(),
                duration = getDuration(),
                views = getViews(),
                nation = getNation()
            )
        )
    }

    return musicList
}

fun getVideos(): List<Album.Video> {
    val videoList = mutableListOf<Album.Video>()
    repeat(10) {
        videoList.add(
            Album.Video(
                title = getVideoName(),
                description = "description: $it",
                year = (1991..2023).random().toString(),
                thumbnail = getRandomImage(),
                artist = getArtist(),
                duration = getDuration(),
                views = getViews(),
                nation = getNation()
            )
        )
    }

    return videoList
}

fun getArtists(): List<Artist> {
    val artistList = mutableListOf<Artist>()
    repeat(10) {
        artistList.add(
            Artist(
                name = getArtistsName(),
                imageUrl = getRandomImage(),
                debutYear = getDebutYear(),
                totalSubscriber = getTotalSubscriber()
            )
        )
    }

    return artistList
}

fun getDebutYear(): String = (1991..2023).random().toString()

fun getTotalSubscriber(): String = (0..103747381).random().toString()

fun getArtist(): Artist = getArtists().random()

fun getArtistsName(): String = artistNames.random()

fun getRandomImage(): Int = (0..images.size).random()

fun getViews(): String = (0..939734712).random().toString()

fun getDuration(): String = durationList.random()

fun getMusicName(): String = musicNameList.random()

fun getNation(): String = nationList.random()

fun getVideoName(): String = videoNameList.random()

fun getMainlyMusicList(): MainlyMusicList =
    MainlyMusicList(
        mainlyThumbnail = getRandomImage(),
        mainlyTitle = musicNameList.random(),
        musics = getMusics()
    )

fun getMainlyVideoList(): MainlyVideoList =
    MainlyVideoList(
        mainlyThumbnail = getRandomImage(),
        mainlyTitle = musicNameList.random(),
        videos = getVideos()
    )

