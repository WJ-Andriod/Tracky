package com.tracky.youtubemusicsample

import com.tracky.youtubemusicsample.data.DataSource
import com.tracky.youtubemusicsample.data.DataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    abstract fun dataSource(dataSourceImpl: DataSourceImpl): DataSource
}
