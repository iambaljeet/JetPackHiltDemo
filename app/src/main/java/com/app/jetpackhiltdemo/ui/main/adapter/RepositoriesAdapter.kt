package com.app.jetpackhiltdemo.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.jetpackhiltdemo.R
import com.app.jetpackhiltdemo.model.DiffUtilRepositoriesModelItem
import com.app.jetpackhiltdemo.model.RepositoriesModel
import com.app.jetpackhiltdemo.utility.hideIfEmptyText
import com.app.jetpackhiltdemo.utility.loadImageFromUrl
import kotlinx.android.synthetic.main.list_item_user_repositories.view.*

class RepositoriesAdapter: ListAdapter<RepositoriesModel.RepositoriesModelItem, RepositoriesViewHolder>(
    DiffUtilRepositoriesModelItem()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user_repositories, parent, false)
        return RepositoriesViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: RepositoriesModel.RepositoriesModelItem?) {
        val owner = item?.owner
        itemView.image_view_owner?.loadImageFromUrl(owner?.avatarUrl)
        itemView.text_view_owner_name.text = item?.fullName?.substringBefore(delimiter = "/")
        itemView.text_view_repository_name.hideIfEmptyText(item?.name)
        itemView.text_view_repository_description.hideIfEmptyText(item?.description)
    }
}