package com.nytime.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nytime.common.GitRepoItemAdapter

import com.nytime.nytimes.R
import com.nytime.nytimes.databinding.FragmentSplashBinding
import com.nytime.ui.BaseFragment
import com.nytime.ui.GitHubRepositoryActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SplashFragment:  BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash), GitRepoItemAdapter.AccountsViewHolder.ItemClickListener{


    override val viewModel by viewModels<GitHubRepositoryActivityViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        splashScreen()
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }



    fun splashScreen() {

        val SPLASH_TIME_OUT = 2000
        Handler().postDelayed({
            //Do some stuff here, like implement deep linking
            findNavController().navigate(SplashFragmentDirections.actionSearch())

        }, SPLASH_TIME_OUT.toLong())
    }

    override fun onItemClick(position: Int, url: String) {

    }


}