package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class ItemGroupTips {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("createdAt")
    var createdAt: Int? = null
    @SerializedName("text")
    var text: String? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("canonicalUrl")
    var canonicalUrl: String? = null
    @SerializedName("photo")
    var photo: PhotoGroupItemTips? = null
    @SerializedName("photourl")
    var photourl: String? = null
    @SerializedName("lang")
    var lang: String? = null
    @SerializedName("likes")
    var likes: LikesItemsGroupTips? = null
    @SerializedName("logView")
    var logView: Boolean? = null
    @SerializedName("agreeCount")
    var agreeCount: Int? = null
    @SerializedName("disagreeCount")
    var disagreeCount: Int? = null
    @SerializedName("todo")
    var todo: Todo? = null
    @SerializedName("user")
    var user: UserItemGroupTips? = null
    @SerializedName("authorInteractionType")
    var authorInteractionType: String? = null

}
