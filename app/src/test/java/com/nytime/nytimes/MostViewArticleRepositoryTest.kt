package com.nytime.nytimes

import com.nytime.nytimes.client.request.ApiResponse
import com.nytime.nytimes.client.request.ErrorResponse
import com.nytime.ui.GitHubRepository
import com.nytime.ui.model.GitHubRepositoryModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MostViewArticleRepositoryTest {

    lateinit var mostViewRepository: GitHubRepository


    @Before
    fun setup() {
        mostViewRepository = GitHubRepository(MockRequestExecutor(false))
    }


    @Test
    fun testFetchCustomerDetails() {

        mostViewRepository.mostViewArticle(
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