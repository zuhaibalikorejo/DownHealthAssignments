package com.gitresp.base

import androidx.lifecycle.ViewModel
import com.gitresp.nytimes.client.request.ErrorResponse
import com.gitresp.nytimes.retrofit.RetrofitRequestExecutorImpl
import com.gitresp.nytimes.utils.SingleLiveEvent


/**
 * <p>
 * @author zuhaib ahmed
 */

abstract class BaseViewModel :
    ViewModel() {
    val networkRequestProgress = SingleLiveEvent<Boolean>()
    val networkFailed = SingleLiveEvent<ErrorResponse?>()
    var baseRepository: BaseRepository? = null

    init {
        baseRepository = BaseRepository(RetrofitRequestExecutorImpl())
    }

}