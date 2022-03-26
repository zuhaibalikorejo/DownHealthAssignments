package com.nytime.ui

import com.nytime.base.BaseRepository
import com.nytime.common.GitRepoRequest
import com.nytime.nytimes.ApiResponseListener
import com.nytime.nytimes.client.RequestExecutor

import com.nytime.ui.model.GitHubRepositoryModel
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