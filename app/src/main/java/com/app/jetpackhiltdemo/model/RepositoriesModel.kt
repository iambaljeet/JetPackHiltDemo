package com.app.jetpackhiltdemo.model


import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class RepositoriesModel : ArrayList<RepositoriesModel.RepositoriesModelItem>(){
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class RepositoriesModelItem(
        @SerializedName("archive_url")
        var archiveUrl: String?,
        @SerializedName("assignees_url")
        var assigneesUrl: String?,
        @SerializedName("blobs_url")
        var blobsUrl: String?,
        @SerializedName("branches_url")
        var branchesUrl: String?,
        @SerializedName("collaborators_url")
        var collaboratorsUrl: String?,
        @SerializedName("comments_url")
        var commentsUrl: String?,
        @SerializedName("commits_url")
        var commitsUrl: String?,
        @SerializedName("compare_url")
        var compareUrl: String?,
        @SerializedName("contents_url")
        var contentsUrl: String?,
        @SerializedName("contributors_url")
        var contributorsUrl: String?,
        @SerializedName("deployments_url")
        var deploymentsUrl: String?,
        @SerializedName("description")
        var description: String?,
        @SerializedName("downloads_url")
        var downloadsUrl: String?,
        @SerializedName("events_url")
        var eventsUrl: String?,
        @SerializedName("fork")
        var fork: Boolean?,
        @SerializedName("forks_url")
        var forksUrl: String?,
        @SerializedName("full_name")
        var fullName: String?,
        @SerializedName("git_commits_url")
        var gitCommitsUrl: String?,
        @SerializedName("git_refs_url")
        var gitRefsUrl: String?,
        @SerializedName("git_tags_url")
        var gitTagsUrl: String?,
        @SerializedName("hooks_url")
        var hooksUrl: String?,
        @SerializedName("html_url")
        var htmlUrl: String?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("issue_comment_url")
        var issueCommentUrl: String?,
        @SerializedName("issue_events_url")
        var issueEventsUrl: String?,
        @SerializedName("issues_url")
        var issuesUrl: String?,
        @SerializedName("keys_url")
        var keysUrl: String?,
        @SerializedName("labels_url")
        var labelsUrl: String?,
        @SerializedName("languages_url")
        var languagesUrl: String?,
        @SerializedName("merges_url")
        var mergesUrl: String?,
        @SerializedName("milestones_url")
        var milestonesUrl: String?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("node_id")
        var nodeId: String?,
        @SerializedName("notifications_url")
        var notificationsUrl: String?,
        @SerializedName("owner")
        var owner: Owner?,
        @SerializedName("private")
        var `private`: Boolean?,
        @SerializedName("pulls_url")
        var pullsUrl: String?,
        @SerializedName("releases_url")
        var releasesUrl: String?,
        @SerializedName("stargazers_url")
        var stargazersUrl: String?,
        @SerializedName("statuses_url")
        var statusesUrl: String?,
        @SerializedName("subscribers_url")
        var subscribersUrl: String?,
        @SerializedName("subscription_url")
        var subscriptionUrl: String?,
        @SerializedName("tags_url")
        var tagsUrl: String?,
        @SerializedName("teams_url")
        var teamsUrl: String?,
        @SerializedName("trees_url")
        var treesUrl: String?,
        @SerializedName("url")
        var url: String?
    ) : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Owner(
            @SerializedName("avatar_url")
            var avatarUrl: String?,
            @SerializedName("events_url")
            var eventsUrl: String?,
            @SerializedName("followers_url")
            var followersUrl: String?,
            @SerializedName("following_url")
            var followingUrl: String?,
            @SerializedName("gists_url")
            var gistsUrl: String?,
            @SerializedName("gravatar_id")
            var gravatarId: String?,
            @SerializedName("html_url")
            var htmlUrl: String?,
            @SerializedName("id")
            var id: Int?,
            @SerializedName("login")
            var login: String?,
            @SerializedName("node_id")
            var nodeId: String?,
            @SerializedName("organizations_url")
            var organizationsUrl: String?,
            @SerializedName("received_events_url")
            var receivedEventsUrl: String?,
            @SerializedName("repos_url")
            var reposUrl: String?,
            @SerializedName("site_admin")
            var siteAdmin: Boolean?,
            @SerializedName("starred_url")
            var starredUrl: String?,
            @SerializedName("subscriptions_url")
            var subscriptionsUrl: String?,
            @SerializedName("type")
            var type: String?,
            @SerializedName("url")
            var url: String?
        ) : Parcelable
    }
}

class DiffUtilRepositoriesModelItem: DiffUtil.ItemCallback<RepositoriesModel.RepositoriesModelItem>() {
    override fun areItemsTheSame(
        oldItem: RepositoriesModel.RepositoriesModelItem,
        newItem: RepositoriesModel.RepositoriesModelItem
    ): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(
        oldItem: RepositoriesModel.RepositoriesModelItem,
        newItem: RepositoriesModel.RepositoriesModelItem
    ): Boolean {
        return newItem == oldItem
    }
}