package com.nytime.ui.search

import android.os.Bundle

import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nytime.common.GitRepoItemAdapter
import com.nytime.nytimes.R
import com.nytime.nytimes.databinding.FragmentSearchBinding
import com.nytime.ui.BaseFragment
import com.nytime.ui.GitHubRepositoryActivityViewModel
import com.nytime.ui.model.Result
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SearchFragment :   BaseFragment<FragmentSearchBinding>(R.layout.fragment_search), GitRepoItemAdapter.AccountsViewHolder.ItemClickListener{

    override val viewModel by viewModels<GitHubRepositoryActivityViewModel>()


//    override val viewModel: GitHubRepositoryActivityViewModel by viewModels(
//    )



    private val dashboardItemList = mutableListOf<Result>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchMostViewArticle();
        dataBinding.recyclerView.layoutManager =
            LinearLayoutManager(context)
        dataBinding.recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        val accountsAdapter = GitRepoItemAdapter(dashboardItemList,this)
        dataBinding.recyclerView.adapter = accountsAdapter

        setUpObservers()
    }



    override fun setUpObservers() {

        viewModel.gitRepoLiveData.observe(viewLifecycleOwner, {
            dashboardItemList.clear()
            dashboardItemList.addAll(it.items!!)
            dataBinding.recyclerView.adapter?.notifyDataSetChanged()
        })
    }

    override fun onItemClick(position: Int, url: String) {
        Toast.makeText(context,"new position:",position)

//        findNavController().navigate(
//            SearchFragmentDirections.actionDetails("zuhaib")
//        )


//        var intent  = Intent(this, MovtViewDetailScreen::class.java)
//        intent.putExtra("url",url)
//        startActivity(intent)
    }


}