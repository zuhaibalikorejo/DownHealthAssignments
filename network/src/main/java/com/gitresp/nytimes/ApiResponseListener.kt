package com.gitresp.nytimes

import com.gitresp.nytimes.client.request.ApiResponse
import com.gitresp.nytimes.client.request.ErrorResponse


interface ApiResponseListener<T> {
    fun onApiSuccess(response: ApiResponse<T>)
    fun onApiFailure(errorResponse: ErrorResponse)
}