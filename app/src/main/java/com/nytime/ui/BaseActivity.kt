package com.nytime.ui


import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar



import androidx.lifecycle.Observer
import com.nytime.base.BaseViewModel

/**
 * Activity ViewModel class for application's dashboard
 * <p>
 * @author zuhaib
 * Email: zuhaib.ahmed@adib.com
 * Company: ADIB
 */

abstract class BaseActivity (
) : AppCompatActivity() {

    protected abstract fun initViewBinding()
    protected abstract val viewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setUpObservers()
    }



    override fun onUserInteraction() {

    }

    open fun setUpObservers() {

        viewModel.networkRequestProgress.observe(
            this,
            Observer {

            })

        viewModel.networkFailed.observe(this, Observer { it?.let {


        } })



    }

}
