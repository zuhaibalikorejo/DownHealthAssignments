package com.gitresp.nytimes.retrofit


import android.os.Handler
import android.os.SystemClock
import com.gitresp.network.R
import com.gitresp.nytimes.AdibNetworkClient
import com.gitresp.nytimes.ApiResponseListener

import com.gitresp.nytimes.BaseRequest

import com.gitresp.nytimes.client.RequestExecutor
import com.gitresp.nytimes.client.Util
import com.gitresp.nytimes.client.request.ErrorResponse


class OfflineRequestExecutorImpl : RequestExecutor {
    private val simulateError = false
    override fun <T> execute(request: BaseRequest, listener: ApiResponseListener<T>) {
        val localData =
            Util.readFileFromAssets(AdibNetworkClient.context, request.offlineResponsePath())
        val thread = Thread {
            SystemClock.sleep(1000)
            Handler(AdibNetworkClient.context.mainLooper)
                .post {
                    if (simulateError) {
                        val errorResponse = ErrorResponse()
                        errorResponse.setErrorTitle(
                            AdibNetworkClient.context.getString(R.string.error)
                        )
                        listener.onApiFailure(errorResponse)
                    } else onNoErrorInResponse(request, listener, localData)
                }
        }
        thread.start()
    }

    private fun <T> onNoErrorInResponse(
        request: BaseRequest,
        listener: ApiResponseListener<T>,
        localData: String
    ) {
    }
}
