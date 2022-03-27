package com.gitresp.nytimes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.gitresp.ui.GitHubRepositoryActivityViewModel
import com.gitresp.ui.GitHubRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GitRepoViewModelTest {

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

        viewmodel.fetchMostViewArticle("a")
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
    fun testResultFullNameData_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)!!.fullName)
    }

    @Test
    fun testResultDescriptionData_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)!!.description)
    }

    @Test
    fun testResultHtmlUrl_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)!!.htmlUrl)
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
    fun testResultUrlData_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.language)
    }


    @Test
    fun testResultDefaultBranch_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.defaultBranch)
    }


    @Test
    fun testResultOpenAccountIssueBranch_null() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.openissuescount)
    }

    @Test
    fun testResultHomePagenull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.homepage)
    }

    @Test
    fun testResultWatchesnull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.watchers)
    }


    @Test
    fun testResultOwnernull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.owner)
    }

    @Test
    fun testResultAwaturnull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.owner!!.avatarUrl)
    }

    @Test
    fun testResultLoginnull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.items?.get(0)?.owner!!.login)
    }


    @Test
    fun testResultTotalCountnull() {
        Assert.assertNotNull(viewmodel.gitRepoLiveData.value!!.totalCount)
    }

}


