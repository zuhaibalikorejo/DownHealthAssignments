package com.nytime.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nytime.common.GitRepoItemAdapter

import com.nytime.nytimes.R
import com.nytime.nytimes.databinding.FragmentSplashBinding
import com.nytime.ui.BaseFragment
import com.nytime.ui.GitHubRepositoryActivityViewModel
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