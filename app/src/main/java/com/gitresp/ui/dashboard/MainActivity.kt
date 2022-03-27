package com.gitresp.ui.dashboard

import androidx.activity.viewModels
import com.gitresp.nytimes.databinding.ActivityMainBinding
import com.gitresp.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity(){

    private lateinit var binding: ActivityMainBinding

    override val viewModel by viewModels<MainActivityViewModel>()


    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }





    }