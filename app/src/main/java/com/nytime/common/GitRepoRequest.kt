
package com.nytime.common


import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.nytime.nytimes.utils.RequestMethod
import com.nytime.request.GitHubRepoBaseRequest
import com.nytime.ui.model.GitHubRepositoryModel

import java.lang.reflect.Type

/**
 * <p>
 * @author zuhaib ahmed
 */
class GitRepoRequest() : GitHubRepoBaseRequest() {
    override fun endpoint(): String = "/repositories?q=a&per_page=50"


    override fun requestMethod(): String = RequestMethod.GET

    override fun postBody(): JsonObject = JsonObject()

    override fun responseType(): Type = object : TypeToken<GitHubRepositoryModel?>() {}.type!!

    override fun offlineResponsePath(): String = "mostViewArticle.json"






}
