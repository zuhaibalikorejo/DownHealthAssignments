package com.nytime.base

import android.app.Application
import com.nytime.nytimes.AdibNetworkClient
import com.nytime.nytimes.BuildConfig
import com.nytime.nytimes.NetworkConfig
import dagger.hilt.android.HiltAndroidApp


/**
 * <p>
 * @author zuhaib ahmed
 */
@HiltAndroidApp
class GitHupRepoApp : Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this

        AdibNetworkClient.createInstance(NetworkConfig.Builder(this,  BuildConfig.BASE_URL).build())
    }


    companion object {

        private var instance: GitHupRepoApp? = null

    }






}