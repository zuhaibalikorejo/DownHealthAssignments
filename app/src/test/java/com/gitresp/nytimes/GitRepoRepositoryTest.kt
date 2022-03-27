package com.gitresp.nytimes

import com.gitresp.nytimes.client.request.ApiResponse
import com.gitresp.nytimes.client.request.ErrorResponse
import com.gitresp.ui.GitHubRepository
import com.gitresp.ui.model.GitHubRepositoryModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GitRepoRepositoryTest {

    lateinit var githubRepository: GitHubRepository


    @Before
    fun setup() {
        githubRepository = GitHubRepository(MockRequestExecutor(false))
    }


    @Test
    fun testFetchCustomerDetails() {

        githubRepository.gitRepoData("a",
            object : ApiResponseListener<GitHubRepositoryModel> {

                override fun onApiSuccess(response: ApiResponse<GitHubRepositoryModel>) {
                    response?.data?.let {
                        Assert.assertNotNull(response)
                        Assert.assertNotNull(response?.data)
                    }
                }

                override fun onApiFailure(errorResponse: ErrorResponse) {
                }
            })
    }





}