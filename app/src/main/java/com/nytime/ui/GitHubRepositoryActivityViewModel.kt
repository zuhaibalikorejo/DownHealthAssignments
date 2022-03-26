package com.nytime.ui




import androidx.lifecycle.MutableLiveData
import com.nytime.base.BaseViewModel
import com.nytime.common.EspressoIdlingResourceTest
import com.nytime.nytimes.ApiResponseListener
import com.nytime.nytimes.client.request.ApiResponse
import com.nytime.nytimes.client.request.ErrorResponse
import com.nytime.ui.model.GitHubRepositoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Activity ViewModel class for application's dashboard
 * <p>
 * @author zuhaib
 * Email: zuhaib.ahmed@adib.com
 * Company: zuhaib
 */
@HiltViewModel
class GitHubRepositoryActivityViewModel @Inject constructor(
    private val repository: GitHubRepository,
) : BaseViewModel() {


    var gitRepoLiveData = MutableLiveData<GitHubRepositoryModel>()


    fun fetchMostViewArticle() {
        EspressoIdlingResourceTest.increment()
        repository.gitRepoData(
            object : ApiResponseListener<GitHubRepositoryModel> {

                override fun onApiSuccess(response: ApiResponse<GitHubRepositoryModel>) {
                    EspressoIdlingResourceTest.decrement()
                    response?.data?.let {
                        gitRepoLiveData.value = it
                    }
                }

                override fun onApiFailure(errorResponse: ErrorResponse) {
                    EspressoIdlingResourceTest.decrement()
                    networkFailed.value = errorResponse
                }
            })
    }









}