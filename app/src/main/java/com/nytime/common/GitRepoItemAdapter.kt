package com.nytime.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.nytime.nytimes.databinding.RecipeItemBinding
import com.nytime.ui.model.Result
/**
 * <p>
 * @author zuhaib ahmed
 */
class GitRepoItemAdapter constructor(
    private val viewItemList: List<Result>,
    private val itemClickListener: AccountsViewHolder.ItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding =
            RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountsViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AccountsViewHolder) {
            val dashboardItem = viewItemList[position] as Result
            holder.updateItem(dashboardItem, position,itemClickListener)
        }
    }

    override fun getItemCount(): Int {
        return viewItemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return viewItemList.size;
    }

    class AccountsViewHolder(var dataBinding: RecipeItemBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun updateItem(mosvtViewItem: Result, position: Int, itemClickListener: ItemClickListener) {

            dataBinding.title.text = mosvtViewItem.name
            dataBinding.author.text = mosvtViewItem.owner?.login
            dataBinding.description.text = mosvtViewItem.description
            dataBinding.forks.text = ""+mosvtViewItem.forks
            dataBinding.stars.text = ""+mosvtViewItem.stars
            mosvtViewItem.owner.apply {
                Glide.with(dataBinding.image)
                    .load(mosvtViewItem.owner!!.avatarUrl)
                    .into(dataBinding.image)
            }




          //  dataBinding.rowClick.setOnClickListener { itemClickListener.onItemClick(position,mosvtViewItem.name!!) }
        }


        interface ItemClickListener {
            fun onItemClick(position: Int,url:String)

        }
    }
}
