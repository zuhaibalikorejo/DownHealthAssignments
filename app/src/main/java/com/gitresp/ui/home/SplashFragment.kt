package com.gitresp.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.gitresp.nytimes.R
import com.gitresp.nytimes.databinding.FragmentSplashBinding
import com.gitresp.ui.BaseFragment
import com.gitresp.ui.GitHubRepositoryActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SplashFragment:  BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash){


    override val viewModel by viewModels<GitHubRepositoryActivityViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    splashScreen()
    }



        fun splashScreen() {

        val SPLASH_TIME_OUT = 2000
        Handler().postDelayed({
            //Do some stuff here, like implement deep linking
            findNavController().navigate(SplashFragmentDirections.actionSearch())

        }, SPLASH_TIME_OUT.toLong())
    }




}