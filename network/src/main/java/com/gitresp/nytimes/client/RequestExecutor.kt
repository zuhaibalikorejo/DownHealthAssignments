package com.gitresp.nytimes.client

import com.gitresp.nytimes.ApiResponseListener
import com.gitresp.nytimes.BaseRequest


interface RequestExecutor {
    fun <T> execute(request: BaseRequest, listener: ApiResponseListener<T>)
}