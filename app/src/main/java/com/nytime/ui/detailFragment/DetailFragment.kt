package com.nytime.ui.detailFragment




import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.nytime.nytimes.R
import com.nytime.nytimes.databinding.FragmentDetailsBinding
import com.nytime.ui.BaseFragment
import com.nytime.ui.GitHubRepositoryActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class DetailFragment:  BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {


    override val viewModel by viewModels<GitHubRepositoryActivityViewModel>()
    // Navigation
    private val args: DetailFragmentArgs by navArgs()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.title.text = args.name
        dataBinding.titleSecond.text = args.language
        dataBinding.forktxt.text = args.fork
        dataBinding.issuetxt.text = args.issues
        dataBinding.defaultBranchtxt.text = args.defualt
        dataBinding.subscribeCounttxt.text = args.subcribecount
        Glide.with(dataBinding.image)
            .load(args.avatarUrl)
            .into(dataBinding.image)
    }



}