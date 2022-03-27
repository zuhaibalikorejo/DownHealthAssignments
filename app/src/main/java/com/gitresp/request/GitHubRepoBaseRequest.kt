package com.gitresp.request

import com.gitresp.nytimes.BaseRequest

/**
 * <p>
 * @author zuhaib ahmed
 */
abstract class GitHubRepoBaseRequest : BaseRequest() {

    override fun toString(): String {
        return postBody().toString()
    }
}