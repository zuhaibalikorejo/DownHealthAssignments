package com.gitresp.di


import com.gitresp.nytimes.BuildConfig
import com.gitresp.nytimes.client.RequestExecutor
import com.gitresp.nytimes.retrofit.OfflineRequestExecutorImpl
import com.gitresp.nytimes.retrofit.RetrofitRequestExecutorImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * <p>
 * @author zuhaib ahmed
 */
@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun get(): RequestExecutor =
    if (BuildConfig.OFFLINE) OfflineRequestExecutorImpl() else RetrofitRequestExecutorImpl()



}