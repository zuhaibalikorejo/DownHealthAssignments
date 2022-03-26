package com.nytime.ui


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


import androidx.lifecycle.Observer
import com.nytime.base.BaseViewModel
import com.nytime.nytimes.client.request.ErrorResponse

/**
 * Activity ViewModel class for application's dashboard
 * <p>
 * @author zuhaib
 * Email: zuhaib.ahmed@adib.com
 * Company: ADIB
 */

/**
 * <p>
 * @author Irshad Kumail
 */
abstract class BaseFragment<D : ViewDataBinding>(
    val containerLayoutId: Int,
) : Fragment() {

    protected abstract val viewModel: BaseViewModel

    protected lateinit var dataBinding: D


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding =
            DataBindingUtil.inflate(layoutInflater, containerLayoutId, container, false)
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    open fun setUpObservers() {

        viewModel.networkRequestProgress.observe(
            viewLifecycleOwner, Observer {
                if (it) {

                } else {

                }
            })

        viewModel.networkFailed.observe(
            viewLifecycleOwner,
            Observer { it?.let { } })


    }
}