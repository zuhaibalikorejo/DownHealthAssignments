package com.nytime.ui.model
/**
 * <p>
 * @author zuhaib ahmed
 */
data class GitHubRepositoryModel(
        val totalCount: Int,
        val incomplete_results: Boolean,
        val items: List<Result>? = null
)


