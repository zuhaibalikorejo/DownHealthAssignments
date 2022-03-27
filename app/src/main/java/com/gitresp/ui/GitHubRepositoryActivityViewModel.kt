package com.gitresp.ui




import androidx.lifecycle.MutableLiveData
import com.gitresp.base.BaseViewModel
import com.gitresp.common.EspressoIdlingResourceTest
import com.gitresp.nytimes.ApiResponseListener
import com.gitresp.nytimes.client.request.ApiResponse
import com.gitresp.nytimes.client.request.ErrorResponse
import com.gitresp.ui.model.GitHubRepositoryModel
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


    fun fetchMostViewArticle(query:String) {
        EspressoIdlingResourceTest.increment()
        repository.gitRepoData(query,
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