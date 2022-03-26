package com.nytime.nytimes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.nytime.ui.GitHubRepositoryActivityViewModel
import com.nytime.ui.GitHubRepository
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
        Assert.assertNotNull(viewmodel.mostViewLiveData.value)
    }


    @Test
    fun testResultLiveData_null() {
        Assert.assertNotNull(viewmodel.mostViewLiveData.value!!.items)
    }

    @Test
    fun testResultHomePageData_null() {
        Assert.assertNotNull(viewmodel.mostViewLiveData.value!!.items?.get(0)!!.homepage)
    }

    @Test
    fun testApiDatanull() {
        Assert.assertNotNull(viewmodel.mostViewLiveData.value!!.items?.get(0)!!.apiUrl)
    }


    @Test
    fun testurlnull() {
        Assert.assertNotNull(viewmodel.mostViewLiveData.value!!.items?.get(0)?.description)
    }

    @Test
    fun testResultUrlata_null() {
        Assert.assertNotNull(viewmodel.mostViewLiveData.value!!.items?.get(0)?.language)
    }






}


