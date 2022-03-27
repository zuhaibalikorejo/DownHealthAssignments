package com.gitresp.nytimes.retrofit

import retrofit2.Call
import retrofit2.http.*

const val GET_REPOS: String = "search/repositories"
interface ApiInterface {

    @GET(GET_REPOS)
     fun getRequest(@Query("q") searchQuery: String,
                            @Query("per_page") perPage: Int):  Call<String?>?

}