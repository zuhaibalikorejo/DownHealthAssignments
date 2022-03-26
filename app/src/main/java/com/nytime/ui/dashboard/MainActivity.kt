package com.nytime.ui.dashboard

import androidx.activity.viewModels
import com.nytime.nytimes.databinding.ActivityMainBinding
import com.nytime.ui.BaseActivity
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