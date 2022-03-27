package com.gitresp.ui.model

import com.google.gson.annotations.SerializedName


data class Owner(
@SerializedName("id") val ownerId: Long,
@SerializedName("login") val login: String,
@SerializedName("avatar_url") val avatarUrl: String
)