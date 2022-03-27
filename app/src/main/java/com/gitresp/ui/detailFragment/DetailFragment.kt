package com.gitresp.ui.detailFragment




import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.gitresp.nytimes.R
import com.gitresp.nytimes.databinding.FragmentDetailsBinding
import com.gitresp.ui.BaseFragment
import com.gitresp.ui.GitHubRepositoryActivityViewModel
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