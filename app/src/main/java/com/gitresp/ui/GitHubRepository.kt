package com.gitresp.ui

import com.gitresp.base.BaseRepository
import com.gitresp.common.GitRepoRequest
import com.gitresp.nytimes.ApiResponseListener
import com.gitresp.nytimes.client.RequestExecutor

import com.gitresp.ui.model.GitHubRepositoryModel
import javax.inject.Inject

/**
 * Activity ViewModel class for application's dashboard
 * <p>
 * @author zuhaib
 * Email: zuhaib.ahmed@adib.com
 * Company: zuhaib
 */
class GitHubRepository @Inject constructor(requestExecutor: RequestExecutor) : BaseRepository(requestExecutor) {


    fun gitRepoData(listener: ApiResponseListener<GitHubRepositoryModel>) {
        requestExecutor.execute(GitRepoRequest(), listener)
    }


}