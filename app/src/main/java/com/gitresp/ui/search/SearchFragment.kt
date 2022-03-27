package com.gitresp.ui.search

import android.os.Bundle
import android.text.TextUtils

import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gitresp.common.GitRepoItemAdapter
import com.gitresp.nytimes.R
import com.gitresp.nytimes.databinding.FragmentSearchBinding
import com.gitresp.ui.BaseFragment
import com.gitresp.ui.GitHubRepositoryActivityViewModel
import com.gitresp.ui.model.Result
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SearchFragment :   BaseFragment<FragmentSearchBinding>(R.layout.fragment_search), GitRepoItemAdapter.AccountsViewHolder.ItemClickListener{

    override val viewModel by viewModels<GitHubRepositoryActivityViewModel>()

    private val dashboardItemList = mutableListOf<Result>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        dataBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        dataBinding.recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        val accountsAdapter = GitRepoItemAdapter(dashboardItemList,this)
        dataBinding.recyclerView.adapter = accountsAdapter

        setUpObservers()
        initSearchListener()
    }



    override fun setUpObservers() {

        viewModel.gitRepoLiveData.observe(viewLifecycleOwner, {
            dataBinding.emptyLayout.visibility = View.GONE
            dashboardItemList.clear()
            dashboardItemList.addAll(it.items!!)
            dataBinding.recyclerView.adapter?.notifyDataSetChanged()
        })
    }


    override fun onItemClick(githubrepoViewItem: Result) {

        if (TextUtils.isEmpty(githubrepoViewItem.language))  githubrepoViewItem.language = ""
        findNavController().navigate(SearchFragmentDirections.actionDetails(githubrepoViewItem.name,githubrepoViewItem.language!!,githubrepoViewItem.forks.toString(),githubrepoViewItem.openissuescount.toString(),githubrepoViewItem.defaultBranch!!,  githubrepoViewItem.owner!!.avatarUrl,githubrepoViewItem.watchers.toString()))

    }



    /** SearchView btn action */
    private fun initSearchListener() {
        dataBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query.isNotEmpty()) {
                    viewModel.fetchMostViewArticle(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }


}