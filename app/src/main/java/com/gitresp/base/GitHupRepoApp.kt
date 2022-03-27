package com.gitresp.base

import android.app.Application
import com.gitresp.nytimes.AdibNetworkClient
import com.gitresp.nytimes.BuildConfig
import com.gitresp.nytimes.NetworkConfig
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