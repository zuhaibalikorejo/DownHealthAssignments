package com.gitresp.nytimes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.gitresp.ui.GitHubRepositoryActivityViewModel
import com.gitresp.ui.GitHubRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MostViewArticleViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var mockRequestExecutor: MockRequestExecutor
    private lateinit var mostViewRepository: GitHubRepository

    private lateinit var viewmodel: GitHubRepositoryActivityViewModel

    @Before
    fun setup() {
        mockRequestExecutor = MockRequestExecutor(false)
        mostViewRepository = GitHubRepository(mockRequestExecutor)
        viewmodel = GitHubRepositoryActivityViewModel(
            mostViewRepository,
        )

        viewmodel.fetchMostViewArticle()
    }

    @Test
    fun testMostViewLiveData_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value)
    }


    @Test
    fun testResultLiveData_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items)
    }

    @Test
    fun testResultHomePageData_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)!!.homepage)
    }

    @Test
    fun testApiDatanull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)!!.apiUrl)
    }


    @Test
    fun testurlnull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.description)
    }

    @Test
    fun testResultUrlata_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.language)
    }






}


