package com.nytime.nytimes.retrofit

import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @GET("/search/repositories?q=a&per_page=50")
    fun getRequest(): Call<String?>?

}