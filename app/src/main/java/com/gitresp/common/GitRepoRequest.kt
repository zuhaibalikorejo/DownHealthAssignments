
package com.gitresp.common


import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.gitresp.nytimes.utils.RequestMethod
import com.gitresp.request.GitHubRepoBaseRequest
import com.gitresp.ui.model.GitHubRepositoryModel

import java.lang.reflect.Type

/**
 * <p>
 * @author zuhaib ahmed
 */
class GitRepoRequest(val query:String) : GitHubRepoBaseRequest() {
    override fun endpoint(): String = query


    override fun requestMethod(): String = RequestMethod.GET

    override fun postBody(): JsonObject = JsonObject()

    override fun responseType(): Type = object : TypeToken<GitHubRepositoryModel?>() {}.type!!

    override fun offlineResponsePath(): String = "gitRepoData.json"






}
